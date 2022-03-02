package com.sampson.shoplist.view

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.CategoryAdapter
import com.sampson.shoplist.adapter.ItemAdapter
import com.sampson.shoplist.dao.ShopApplication
import com.sampson.shoplist.model.Category
import com.sampson.shoplist.model.Item
import com.sampson.shoplist.viewmodel.CategoryViewModel
import com.sampson.shoplist.viewmodel.CategoryViewModelFactory
import com.sampson.shoplist.viewmodel.ItemViewModel
import com.sampson.shoplist.viewmodel.ItemViewModelFactory


class ItemsActivity : AppCompatActivity() {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((application as ShopApplication).repository)
    }

    private val categoryViewModel: CategoryViewModel by viewModels {
        CategoryViewModelFactory((application as ShopApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val btnAddItem: Button = findViewById(R.id.btnItemsActivityAddItem)
        val btnAddCategory: Button = findViewById(R.id.btnItemsActivityAddCategory)
        val txtSearchItem: TextView = findViewById(R.id.txtItemActivityItemSearch)

        var categoriesList = mutableListOf<Category>()

        val pullToRefresh: SwipeRefreshLayout = findViewById(R.id.refreshRvItems)


        val itemAdapter = ItemAdapter(baseContext)

        val categoryAdapter =
            CategoryAdapter(baseContext, object : CategoryAdapter.CategoryClickListener {
                override fun onCategoryClick(category: Category) {
                    itemViewModel.selectItemByCategory(category.id)
                        .observe(this@ItemsActivity) { items ->
                            items.let { itemAdapter.submitList(it) }
                        }
                }

            })
        val rvCategory: RecyclerView = findViewById(R.id.rvItemActivityCategory)
        rvCategory.adapter = categoryAdapter


        val rvItem: RecyclerView = findViewById(R.id.rvItemActivityItems)
        rvItem.adapter = itemAdapter

        itemViewModel.allItems.observe(this) { items ->
            items.let { itemAdapter.submitList(it) }
        }

        categoryViewModel.allCategories.observe(this) { categories ->
            categories.let {
                categoryAdapter.submitList(it)
                categoriesList = it
            }
        }

        pullToRefresh.setOnRefreshListener {
            itemViewModel.allItems.observe(this) { items ->
                items.let { itemAdapter.submitList(it) }
            }
            pullToRefresh.isRefreshing = false
        }

        val helperItem = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val item = itemAdapter.getItemAtPosition(position)
                AlertDialog.Builder(this@ItemsActivity).apply {
                    setTitle("Confirma a exclusão do item ${item.name}?")
                    setNegativeButton("Não", DialogInterface.OnClickListener { _, _ ->
                        itemViewModel.allItems.observe(this@ItemsActivity) { items ->
                            items.let { itemAdapter.submitList(it) }
                        }
                    })
                    setPositiveButton("Sim", DialogInterface.OnClickListener { _, _ ->
                        itemViewModel.deleteItem(item)
                        itemViewModel.allItems.observe(this@ItemsActivity) { items ->
                            items.let { itemAdapter.submitList(it) }
                        }
                        Toast.makeText(context, "Item excluído", Toast.LENGTH_SHORT).show()
                    }).show()
                }
            }
        }

        val helperCategory =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.UP or ItemTouchHelper.DOWN) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    val category = categoryAdapter.getItemAtPosition(position)
                    AlertDialog.Builder(this@ItemsActivity).apply {
                        setTitle("Confirma a exclusão da categoria ${category.category_name}?")
                        setNegativeButton("Não", DialogInterface.OnClickListener { _, _ ->
                            categoryViewModel.allCategories.observe(this@ItemsActivity) { items ->
                                items.let { categoryAdapter.submitList(it) }
                            }
                        })
                        setPositiveButton("Sim", DialogInterface.OnClickListener { _, _ ->
                            categoryViewModel.deleteCategory(category)
                            categoryViewModel.allCategories.observe(this@ItemsActivity) { items ->
                                items.let { categoryAdapter.submitList(it) }
                            }
                            Toast.makeText(context, "Categoria excluída", Toast.LENGTH_SHORT).show()
                        }).show()
                    }
                }

            }

        val itemTouchHelper = ItemTouchHelper(helperItem)
        itemTouchHelper.attachToRecyclerView(rvItem)

        val categoryTouchHelper = ItemTouchHelper(helperCategory)
        categoryTouchHelper.attachToRecyclerView(rvCategory)

        val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val itemName = it.data?.getStringExtra("itemName") as String
                val itemCategory = it.data?.getStringExtra("itemCategory") as String
                categoryViewModel.selectCategoryIdByName(itemCategory).observe(this) { categoryId ->
                    categoryId.let {
                        val item = Item(0, itemName, it)
                        itemViewModel.insertItem(item)
                    }
                }
            }
        }

        btnAddItem.setOnClickListener {
            val list = categoriesList.groupBy { it.category_name }.keys
            val intent = Intent(this, CreateItemActivity::class.java).apply {
                putStringArrayListExtra("Categories", ArrayList(list))
            }
            register.launch(intent)
        }

        btnAddCategory.setOnClickListener {
            val input = EditText(this).apply {
                hint = "Adicionar categoria..."
                inputType = InputType.TYPE_CLASS_TEXT
            }
            AlertDialog.Builder(this).apply {
                setView(input)
                setNegativeButton("Cancel", null)
                setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                    if (input.text.isEmpty()) {
                        return@OnClickListener
                    } else {
                        val category = Category(0, input.text.toString())
                        categoryViewModel.insertCategory(category)
                        categoryViewModel.allCategories.observe(this@ItemsActivity) { categories ->
                            categories.let { categoryAdapter.submitList(it) }
                        }
                        Toast.makeText(
                            context,
                            "Categoria: ${input.text.toString()} adicionada corretamente.",
                            Toast.LENGTH_SHORT
                        ).show()
                        val inputManager: InputMethodManager = getSystemService(
                            INPUT_METHOD_SERVICE
                        ) as InputMethodManager
                        inputManager.hideSoftInputFromWindow(input.windowToken, 0)
                    }
                })
            }.show()
        }

        txtSearchItem.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val inputManager: InputMethodManager = getSystemService(
                    INPUT_METHOD_SERVICE
                ) as InputMethodManager
                inputManager.hideSoftInputFromWindow(txtSearchItem.windowToken, 0)

                itemViewModel.selectItem("%${txtSearchItem.text.toString()}%")
                    .observe(this) { items ->
                        items.let { itemAdapter.submitList(it) }
                    }
                true
            } else {
                Toast.makeText(baseContext, "Item não encontrado", Toast.LENGTH_SHORT).show()
                false
            }
        }
    }
}