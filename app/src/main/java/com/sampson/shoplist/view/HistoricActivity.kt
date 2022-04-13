package com.sampson.shoplist.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.viewModels
import com.robinhood.spark.SparkView
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.GraphicAdapter
import com.sampson.shoplist.dao.ShopApplication
import com.sampson.shoplist.model.List
import com.sampson.shoplist.viewmodel.ListViewModel
import com.sampson.shoplist.viewmodel.ListViewModelFactory

class HistoricActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val listViewModel: ListViewModel by viewModels {
        ListViewModelFactory((application as ShopApplication).repository)
    }

    private val adapter = GraphicAdapter()
    lateinit var graphic : SparkView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historic)

        val txtShopDate: TextView = findViewById(R.id.txtShopDateHistoricActivity)
        val txtShopValue: TextView = findViewById(R.id.txtShopValueHistoricActivity)
        val spinSource: Spinner = findViewById(R.id.spinSelectSourceHistoricActivity)
        graphic = findViewById(R.id.historicGraphic)


        val spinList = arrayListOf<String>()
        spinList.apply {
            add("Valores totais")
            add("Items mais comprados")
            add("Quantidades compradas")
        }
        spinSource.onItemSelectedListener = this

        val arrayAdapter = spinList.let {
            ArrayAdapter(this, android.R.layout.simple_list_item_1, spinList)
        }
        spinSource.adapter = arrayAdapter

        graphic.adapter = adapter


        graphic.isScrubEnabled = true
        graphic.setScrubListener { itemData ->
            if (itemData is List) {
                txtShopDate.text = itemData.shop_date
                txtShopValue.text = itemData.total_value.toString()
            }
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p2) {
            0 -> {
                graphic.lineColor = Color.RED
                listViewModel.allLists.observe(this) { items ->
                    items.let { adapter.submitList(it) }
                }
            }

            1 -> {
                graphic.lineColor = Color.BLUE
                listViewModel.selectItemsMostBought.observe(this) { items ->
                    items.let { adapter.submitList(it) }
                }
            }
            2 -> {
                graphic.lineColor = Color.GREEN
                listViewModel.selectItemsHistoric.observe(this) { items ->
                    items.let { adapter.submitList(it) }
                }
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}