package com.sampson.shoplist.adapter

import com.robinhood.spark.SparkAdapter
import com.sampson.shoplist.model.List

class GraphicAdapter : SparkAdapter() {

    private var shopList = mutableListOf<List>()

    override fun getCount() = shopList.size

    override fun getItem(index: Int) = shopList[index]

    override fun getY(index: Int): Float {
        val chosedData = shopList[index]
        return chosedData.total_value.toFloat()
    }

    fun submitList(shopList: MutableList<List>){
        this.shopList = shopList
        notifyDataSetChanged()
    }
}