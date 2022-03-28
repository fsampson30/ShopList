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
import com.sampson.shoplist.model.ItemsListCategory

class ListDetailsAdapter(
    val context: Context
) : RecyclerView.Adapter<ListDetailsAdapter.ListDetailsViewHolder>() {

    var itemsList = mutableListOf<ItemsListCategory>()
    var code: Int = 0

    class ListDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgItem: ImageView = itemView.findViewById(R.id.imgListItemsCardPicture)
        val txtItemName: TextView = itemView.findViewById(R.id.txtListItemsCardItemName)
        val txtItemQuantity: TextView = itemView.findViewById(R.id.txtQttListItemsActivity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListDetailsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_items_card, parent, false)
        return ListDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListDetailsViewHolder, position: Int) {
        holder.imgItem.setImageResource(ImageResources.getImageResource(itemsList[position].category))
        holder.txtItemName.text = itemsList[position].item_name
        holder.txtItemQuantity.text = itemsList[position].quantity.toString()
    }

    override fun getItemCount(): Int = itemsList.size

    fun submitList(list: MutableList<ItemsListCategory>) {
        this.itemsList = list
        notifyDataSetChanged()
    }

    fun paintTextView(position: Int) {
        
    }
}