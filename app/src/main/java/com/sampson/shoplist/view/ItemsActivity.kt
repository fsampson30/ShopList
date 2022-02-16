package com.sampson.shoplist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.CategoryAdapter
import com.sampson.shoplist.adapter.ItemAdapter
import com.sampson.shoplist.model.PopulateModel

class ItemsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val category = PopulateModel().populateCategory()
        val items = PopulateModel().populateItem()

        val categoryAdapter = CategoryAdapter(baseContext, category)
        val rvCategory: RecyclerView = findViewById(R.id.rvItemActivityCategory)
        rvCategory.adapter = categoryAdapter

        val itemAdapter = ItemAdapter(baseContext, items)
        val rvItem: RecyclerView = findViewById(R.id.rvItemActivityItems)
        rvItem.adapter = itemAdapter
    }
}