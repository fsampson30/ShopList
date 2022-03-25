package com.sampson.shoplist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.ListDetailsAdapter
import com.sampson.shoplist.dao.ShopApplication
import com.sampson.shoplist.viewmodel.ListViewModel
import com.sampson.shoplist.viewmodel.ListViewModelFactory

class ListDetailsActivity : AppCompatActivity() {

    private val listViewModel: ListViewModel by viewModels {
        ListViewModelFactory((application as ShopApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_details)

        val param = intent.extras?.get("code") as String

        val rvListLitems = findViewById<RecyclerView>(R.id.rvShowItemsListDetailsActivity)
        val itensAdapter = ListDetailsAdapter(baseContext)
        rvListLitems.adapter = itensAdapter

        listViewModel.selectItemsByCode(param).observe(this) { items ->
            items.let { itensAdapter.submitList(it) }
        }
    }
}