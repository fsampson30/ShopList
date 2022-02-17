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
import com.sampson.shoplist.controller.ImageResources.getImageResource
import com.sampson.shoplist.model.Item

class ItemAdapter (
    private val context: Context,
    private var itemsList: ArrayList<Item>
        ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtItemName: TextView = itemView.findViewById(R.id.txtItemCardItemName)
        val imgItemPicture: ImageView = itemView.findViewById(R.id.imgItemCardPicture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_card,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.txtItemName.text = itemsList[position].name
        holder.imgItemPicture.setImageResource(getImageResource(itemsList[position].category))
    }

    override fun getItemCount() = itemsList.size
}