package com.sampson.shoplist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.model.List

class ShowListAdapter(
    private val context: Context,
    private val clickListener: ListClickListener

) : RecyclerView.Adapter<ShowListAdapter.ShowListViewHolder>(){

    var createdLists = mutableListOf<List>()

    class ShowListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtListName = itemView.findViewById<TextView>(R.id.txtCardShowListListName)
        val txtShopDate = itemView.findViewById<TextView>(R.id.txtCardShowListShopDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_card, parent,false)
        return ShowListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowListViewHolder, position: Int) {
        holder.txtListName.text = createdLists[position].list_name
        holder.txtShopDate.text = createdLists[position].shop_date
        holder.itemView.setOnClickListener { clickListener.onListClickListener(createdLists[position]) }
    }

    override fun getItemCount() = createdLists.size

    fun submitList(list: MutableList<List>){
        this.createdLists = list
        notifyDataSetChanged()
    }

    interface ListClickListener {
        fun onListClickListener(list: List)
    }


}