package com.sampson.shoplist.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.model.Item
import com.sampson.shoplist.model.Market
import com.sampson.shoplist.model.PopulateModel

class MarketAdapter(
    private val context: Context,
    private val clickListener: MarketClickListener

    ) : RecyclerView.Adapter<MarketAdapter.MarketViewHolder>() {

    private var marketList = mutableListOf<Market>()

    class MarketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNameMarket: TextView = itemView.findViewById(R.id.txtMarketCardName)
        val imgMarket: ImageView = itemView.findViewById(R.id.imgMarketCardPicture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.market_card, parent, false)
        return MarketViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
        holder.txtNameMarket.text = marketList[position].name
        holder.imgMarket.setImageResource(marketList[position].picture)
        holder.itemView.setOnClickListener { clickListener.onMarketCLick(marketList[position])}
    }

    override fun getItemCount() = marketList.size

    fun submitList(markets: MutableList<Market>) {
        this.marketList = markets
        notifyDataSetChanged()
    }

    interface MarketClickListener {
        fun onMarketCLick(market: Market)
    }
}


