package com.sampson.shoplist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.CategoryAdapter
import com.sampson.shoplist.adapter.ShowListAdapter
import com.sampson.shoplist.dao.ShopApplication
import com.sampson.shoplist.model.Category
import com.sampson.shoplist.model.List
import com.sampson.shoplist.viewmodel.ListViewModel
import com.sampson.shoplist.viewmodel.ListViewModelFactory

class ShowListsActivity : AppCompatActivity() {

    private val listViewModel: ListViewModel by viewModels {
        ListViewModelFactory((application as ShopApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_lists)

        val showListAdapter =
            ShowListAdapter(baseContext, object : ShowListAdapter.ListClickListener {
                override fun onListClickListener(list: List) {
                    val intent = Intent(baseContext, ListDetailsActivity::class.java)
                    startActivity(intent)
                }
            })

        val rvShowLists : RecyclerView = findViewById(R.id.rvListsShowListsActivity)
        rvShowLists.adapter = showListAdapter

        listViewModel.allLists.observe(this){ lists ->
            lists.let { showListAdapter.submitList(it) }
        }
    }


}