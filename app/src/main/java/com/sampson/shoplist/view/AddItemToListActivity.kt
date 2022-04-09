package com.sampson.shoplist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.ItemAdapter
import com.sampson.shoplist.dao.ShopApplication
import com.sampson.shoplist.viewmodel.ItemViewModel
import com.sampson.shoplist.viewmodel.ItemViewModelFactory

class AddItemToListActivity : AppCompatActivity() {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((application as ShopApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item_to_list)

        val edtSearchItem: EditText = findViewById(R.id.edtSearchItemAddItemToListActivity)
        val edtQttItem: EditText = findViewById(R.id.edtQttAddItemToListActivity)
        val lblItemName: TextView = findViewById(R.id.lblShowItemAddItemToListActivity)
        val rvItems: RecyclerView = findViewById(R.id.rvSHowItemsAddItemToListActivity)
        val btnConfirm: Button = findViewById(R.id.btnConfirmAddItemToListActivity)
        val pullToRefresh: SwipeRefreshLayout = findViewById(R.id.refreshrvSHowItemsAddItemToListActivity)

        val itemAdapter = ItemAdapter(baseContext)
        rvItems.adapter = itemAdapter

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)



        itemViewModel.allItems.observe(this) { items ->
            items.let { itemAdapter.submitList(it) }
        }

        pullToRefresh.setOnRefreshListener {
            itemViewModel.allItems.observe(this) { items ->
                items.let { itemAdapter.submitList(it) }
            }
            edtSearchItem.text.clear()
            pullToRefresh.isRefreshing = false
        }

        val helperAddItem = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
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
                lblItemName.text = item.name
                itemViewModel.allItems.observe(this@AddItemToListActivity) { items ->
                    items.let { itemAdapter.submitList(it) }
                }
            }
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

        btnConfirm.setOnClickListener {
            if (edtQttItem.text.isEmpty() or lblItemName.text.isEmpty()) {
                edtQttItem.error = "Obrigatório"
            } else {
                Toast.makeText(baseContext, "Confirmando", Toast.LENGTH_SHORT).show()
            }
        }

        val itemTouchHelper = ItemTouchHelper(helperAddItem)
        itemTouchHelper.attachToRecyclerView(rvItems)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}