package com.sampson.shoplist.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.robinhood.spark.SparkView
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.GraphicAdapter
import com.sampson.shoplist.dao.ShopApplication
import com.sampson.shoplist.model.List
import com.sampson.shoplist.viewmodel.ListViewModel
import com.sampson.shoplist.viewmodel.ListViewModelFactory

class HistoricActivity : AppCompatActivity() {

    private val listViewModel: ListViewModel by viewModels {
        ListViewModelFactory((application as ShopApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historic)

        val txtShopDate : TextView = findViewById(R.id.txtShopDateHistoricActivity)
        val txtShopValue: TextView = findViewById(R.id.txtShopValueHistoricActivity)
        val graphic : SparkView = findViewById(R.id.historicGraphic)
        val adapter = GraphicAdapter()

        graphic.adapter = adapter
        graphic.lineColor = Color.RED

        graphic.isScrubEnabled = true
        graphic.setScrubListener { itemData ->
            if (itemData is List) {
                txtShopDate.text = itemData.shop_date
                txtShopValue.text = itemData.total_value.toString()
            }
        }

        listViewModel.allLists.observe(this) { items ->
            items.let { adapter.submitList(it) }
        }
    }
}