package com.sampson.shoplist.view

import android.content.Intent
import android.net.Uri
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

        val marketAdapter = MarketAdapter(baseContext, object : MarketAdapter.MarketClickListener{
            override fun onMarketCLick(market: Market) {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(market.url)
                }
                startActivity(intent)
            }
        })

        val marketsList = PopulateModel.populateMarket()

        val rvMarkets: RecyclerView = findViewById(R.id.rvMarkets)
        rvMarkets.adapter = marketAdapter
        marketAdapter.submitList(marketsList)



    }
}