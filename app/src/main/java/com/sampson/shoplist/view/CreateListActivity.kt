package com.sampson.shoplist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.ItemAdapter
import com.sampson.shoplist.dao.ShopApplication
import com.sampson.shoplist.viewmodel.ItemViewModel
import com.sampson.shoplist.viewmodel.ItemViewModelFactory

class CreateListActivity : AppCompatActivity() {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((application as ShopApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_list)

        val btnClearList : Button = findViewById(R.id.btnClearListCreateListActivity)
        val btnConfirmList: Button = findViewById(R.id.btnConfirmListCreateListActitivy)
        val edtSearchItem: EditText = findViewById(R.id.edtSearchItemCreateListActivity)
        val edtShopDate: EditText = findViewById(R.id.edtShopDateCreateListActivity)

        val rvShowItems: RecyclerView = findViewById(R.id.rvShowItemsCreateListActivity)
        val rvAddItems: RecyclerView = findViewById(R.id.rvAddItemsCreateListActivity)

        val itemAdapter = ItemAdapter(baseContext)
        rvShowItems.adapter = itemAdapter

        itemViewModel.allItems.observe(this) { items ->
            items.let { itemAdapter.submitList(it) }
        }

        btnClearList.setOnClickListener {
            Toast.makeText(baseContext, "Clearing List", Toast.LENGTH_SHORT).show()
        }

        btnConfirmList.setOnClickListener {
            Toast.makeText(baseContext, "Confirming List", Toast.LENGTH_SHORT).show()
        }


    }
}