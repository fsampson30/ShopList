package com.sampson.shoplist.view

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.CreateListAdapter
import com.sampson.shoplist.adapter.ItemAdapter
import com.sampson.shoplist.controller.RandomUtils
import com.sampson.shoplist.dao.ShopApplication
import com.sampson.shoplist.model.List
import com.sampson.shoplist.viewmodel.ItemViewModel
import com.sampson.shoplist.viewmodel.ItemViewModelFactory
import com.sampson.shoplist.viewmodel.ListViewModel
import com.sampson.shoplist.viewmodel.ListViewModelFactory

class CreateListActivity : AppCompatActivity() {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((application as ShopApplication).repository)
    }

    private val listViewModel: ListViewModel by viewModels{
        ListViewModelFactory((application as ShopApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_list)

        val btnClearList: Button = findViewById(R.id.btnClearListCreateListActivity)
        val btnConfirmList: Button = findViewById(R.id.btnConfirmListCreateListActitivy)
        val edtSearchItem: EditText = findViewById(R.id.edtSearchItemCreateListActivity)
        val edtShopDate: EditText = findViewById(R.id.edtShopDateCreateListActivity)

        val rvShowItems: RecyclerView = findViewById(R.id.rvShowItemsCreateListActivity)
        val rvAddItems: RecyclerView = findViewById(R.id.rvAddItemsCreateListActivity)

        val pullToRefresh: SwipeRefreshLayout =
            findViewById(R.id.refreshRvShowItemsCreateListActivity)

        val itemAdapter = ItemAdapter(baseContext)
        rvShowItems.adapter = itemAdapter

        val createList = CreateListAdapter(baseContext)
        rvAddItems.adapter = createList

        val listHash = RandomUtils.returnRandomInt()

        itemViewModel.allItems.observe(this) { items ->
            items.let { itemAdapter.submitList(it) }
        }

        btnClearList.setOnClickListener {
            createList.removeAllItems()
        }

        btnConfirmList.setOnClickListener {
            val input = EditText(this).apply {
                hint = "Digite o nome da lista..."
                inputType = InputType.TYPE_CLASS_TEXT
            }
            AlertDialog.Builder(this).apply {
                setView(input)
                setNegativeButton("Cancel",null)
                setPositiveButton("OK",DialogInterface.OnClickListener{ _, _ ->
                    if (input.text.isEmpty()){
                        return@OnClickListener
                    } else {
                        val list = List(0,edtShopDate.text.toString(),listHash,input.text.toString(),0.0)
                        val items = createList.retrieveItemsList()
                        listViewModel.insertList(list)
                        listViewModel.insertItemsList(items)
                        edtShopDate.text.clear()
                        edtSearchItem.text.clear()
                    }
                }).show()
            }
            Toast.makeText(this@CreateListActivity,"Lista ${input.text.toString()} adicionada corretamente",Toast.LENGTH_SHORT)
        }

        pullToRefresh.setOnRefreshListener {
            itemViewModel.allItems.observe(this) { items ->
                items.let { itemAdapter.submitList(it) }
            }
            edtSearchItem.text.clear()
            pullToRefresh.isRefreshing = false
        }

        edtSearchItem.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val inputManager: InputMethodManager = getSystemService(
                    INPUT_METHOD_SERVICE
                ) as InputMethodManager
                inputManager.hideSoftInputFromWindow(edtSearchItem.windowToken, 0)

                itemViewModel.selectItem("%${edtSearchItem.text.toString()}%")
                    .observe(this) { items ->
                        items.let { itemAdapter.submitList(it) }
                    }
                true
            } else {
                Toast.makeText(baseContext, "Item não encontrado", Toast.LENGTH_SHORT).show()
                false
            }
        }

        val helperAddItem = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
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
                createList.addItem(item, listHash)
                itemViewModel.allItems.observe(this@CreateListActivity) { items ->
                    items.let { itemAdapter.submitList(it) }
                }
            }
        }

        val helperRemoveItem = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                createList.removeItem(position)
            }
        }

        val helperAddQtt = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                createList.addQuantity(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(helperAddItem)
        itemTouchHelper.attachToRecyclerView(rvShowItems)

        val itemRemoveHelper = ItemTouchHelper(helperRemoveItem)
        itemRemoveHelper.attachToRecyclerView(rvAddItems)

        val itemAddQuantity = ItemTouchHelper(helperAddQtt)
        itemAddQuantity.attachToRecyclerView(rvAddItems)
    }
}