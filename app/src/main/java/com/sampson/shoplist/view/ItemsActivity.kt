package com.sampson.shoplist.view

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.viewmodel.ItemViewModel
import com.sampson.shoplist.viewmodel.ItemViewModelFactory
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.CategoryAdapter
import com.sampson.shoplist.adapter.ItemAdapter
import com.sampson.shoplist.dao.ShopApplication
import com.sampson.shoplist.dao.ShopRepository
import com.sampson.shoplist.model.Category
import com.sampson.shoplist.model.Item
import com.sampson.shoplist.model.PopulateModel.populateCategory
import com.sampson.shoplist.viewmodel.CategoryViewModel
import com.sampson.shoplist.viewmodel.CategoryViewModelFactory

class ItemsActivity : AppCompatActivity() {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((application as ShopApplication).repository)
    }

    private val categotyViewModel: CategoryViewModel by viewModels {
        CategoryViewModelFactory((application as ShopApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val btnAddItem: Button = findViewById(R.id.btnItemsActivityAddItem)
        val btnAddCategory: Button = findViewById(R.id.btnItemsActivityAddCategory)

        val categoryAdapter = CategoryAdapter(baseContext)
        val rvCategory: RecyclerView = findViewById(R.id.rvItemActivityCategory)
        rvCategory.adapter = categoryAdapter

        val itemAdapter = ItemAdapter(baseContext)
        val rvItem: RecyclerView = findViewById(R.id.rvItemActivityItems)
        rvItem.adapter = itemAdapter

        itemViewModel.allItems.observe(this) { items ->
            items.let { itemAdapter.submitList(it) }
        }

        categotyViewModel.allCategories.observe(this){ categories ->
            categories.let { categoryAdapter.submitList(it) }

        }

        btnAddItem.setOnClickListener {
            val input = EditText(this).apply {
                hint = "Adicionar item..."
                inputType = InputType.TYPE_CLASS_TEXT
            }
            AlertDialog.Builder(this).apply {
                setView(input)
                setNegativeButton("Cancel", null)
                setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                    if (input.text.isEmpty()) {
                        return@OnClickListener
                    } else {
                        val item = Item(0,input.text.toString(),10)
                        itemViewModel.insertItem(item)
                        itemViewModel.allItems.observe(this@ItemsActivity){ items ->
                            items.let { itemAdapter.submitList(it) }
                        }
                        Toast.makeText(context, "Item: ${input.text.toString()} adicionado corretamente", Toast.LENGTH_SHORT).show()
                    }
                }).show()
            }
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
                        val category = Category(0,input.text.toString())
                        categotyViewModel.insertCategory(category)
                        categotyViewModel.allCategories.observe(this@ItemsActivity){ categories ->
                            categories.let { categoryAdapter.submitList(it) }
                        }
                        Toast.makeText(context, "Categoria: ${input.text.toString()} adicionada corretamente.", Toast.LENGTH_SHORT).show()
                    }
                })
            }.show()
        }
    }
}