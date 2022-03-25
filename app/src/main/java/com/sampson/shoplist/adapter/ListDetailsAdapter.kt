package com.sampson.shoplist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.controller.ImageResources
import com.sampson.shoplist.model.ItemsList

class ListDetailsAdapter(
    val context : Context
) : RecyclerView.Adapter<ListDetailsAdapter.ListDetailsViewHolder>(){

    var itemsList = mutableListOf<ItemsList>()

    class ListDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgItem = itemView.findViewById<ImageView>(R.id.imgListItemsCardPicture)
        val txtItemName = itemView.findViewById<TextView>(R.id.txtListItemsCardItemName)
        val txtItemQuantity = itemView.findViewById<TextView>(R.id.txtQttListItemsActivity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListDetailsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_items_card, parent, false)
        return ListDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListDetailsViewHolder, position: Int) {
        holder.imgItem.setImageResource(R.drawable.others)
        holder.txtItemName.text = itemsList[position].item_name
        holder.txtItemQuantity.text = itemsList[position].quantity.toString()
    }

    override fun getItemCount(): Int = itemsList.size

    fun sumbitList(list : MutableList<ItemsList>){
        this.itemsList = list
        notifyDataSetChanged()
    }
}