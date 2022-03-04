package com.sampson.shoplist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.MarketAdapter
import com.sampson.shoplist.model.Market
import com.sampson.shoplist.model.PopulateModel

class MarketsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_markets)

        val marketAdapter = MarketAdapter(baseContext)

        val marketsList = PopulateModel.populateMarket()
        Log.d("LISTA", marketsList.size.toString())

        val rvMarkets: RecyclerView = findViewById(R.id.rvMarkets)
        rvMarkets.adapter = marketAdapter
        marketAdapter.submitList(marketsList)



    }
}