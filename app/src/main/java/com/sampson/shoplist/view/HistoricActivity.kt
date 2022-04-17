package com.sampson.shoplist.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    lateinit var graphic: SparkView
    lateinit var txtShopDate: TextView
    lateinit var txtShopValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historic)

        txtShopDate = findViewById(R.id.txtShopDateHistoricActivity)
        txtShopValue = findViewById(R.id.txtShopValueHistoricActivity)
        val spinSource: Spinner = findViewById(R.id.spinSelectSourceHistoricActivity)
        graphic = findViewById(R.id.historicGraphic)


        val spinList = arrayListOf<String>()
        spinList.apply {
            add(getString(R.string.valores_totais))
            add(getString(R.string.items_most_bought))
            add(getString(R.string.qtt_bought))
        }
        spinSource.onItemSelectedListener = this

        val arrayAdapter = spinList.let {
            ArrayAdapter(this, android.R.layout.simple_list_item_1, spinList)
        }
        spinSource.adapter = arrayAdapter

        graphic.adapter = adapter

        graphic.setScrubListener { itemData ->
            if (itemData is List) {
                when (spinSource.selectedItemPosition) {
                    0 -> {
                        "Data da Compra:   ${itemData.shop_date}".also { txtShopDate.text = it }
                        "Valor da Compra:   R$ ${itemData.total_value}".also { txtShopValue.text = it }
                    }
                    1 -> {
                        "Item:   ${itemData.list_name}".also { txtShopDate.text = it }
                        "Quantidade:   ${itemData.total_value.toInt()}".also { txtShopValue.text = it }
                    }
                    2 -> {
                        "Data da Compra:   ${itemData.shop_date}".also { txtShopDate.text = it }
                        "Total de Itens:   ${itemData.total_value.toInt()}".also { txtShopValue.text = it }
                    }
                }
            }
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p2) {
            0 -> {
                clearTexts()
                graphic.isScrubEnabled = false
                graphic.lineColor = Color.RED
                listViewModel.allListsAsc.observe(this) { items ->
                    items.let { adapter.submitList(it) }
                    if(items.size > 1) {
                        graphic.isScrubEnabled = true
                    }
                    Log.d("FLAVIO2", items.size.toString())
                }
            }

            1 -> {
                clearTexts()
                graphic.isScrubEnabled = false
                graphic.lineColor = Color.BLUE
                listViewModel.selectItemsMostBought.observe(this) { items ->
                    items.let { adapter.submitList(it) }
                    if(items.size > 1) {
                        graphic.isScrubEnabled = true
                    }
                    Log.d("FLAVIO3", items.size.toString())
                }
            }
            2 -> {
                clearTexts()
                graphic.isScrubEnabled = false
                graphic.lineColor = Color.GREEN
                listViewModel.selectItemsHistoric.observe(this) { items ->
                    items.let { adapter.submitList(it) }
                    if(items.size > 1) {
                        graphic.isScrubEnabled = true
                    }
                    Log.d("FLAVIO4", items.size.toString())
                }
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    fun clearTexts(){
        txtShopDate.text = ""
        txtShopValue.text = ""
    }
}