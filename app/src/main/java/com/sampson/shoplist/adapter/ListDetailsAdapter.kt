package com.sampson.shoplist.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.controller.ImageResources
import com.sampson.shoplist.model.ItemsListCategory

class ListDetailsAdapter(
    val context: Context
) : RecyclerView.Adapter<ListDetailsAdapter.ListDetailsViewHolder>() {

    var itemsList = mutableListOf<ItemsListCategory>()

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

        holder.itemView.setOnClickListener {
            paintItem(holder.txtItemName)
            paintItem(holder.txtItemQuantity)
        }
    }

    override fun getItemCount(): Int = itemsList.size

    fun submitList(list: MutableList<ItemsListCategory>) {
        this.itemsList = list
        notifyDataSetChanged()
    }

    private fun paintItem(tvItemName : TextView) {
        if (tvItemName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG > 0)  {
            tvItemName.paintFlags = tvItemName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        } else {
            tvItemName.paintFlags = tvItemName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

    }
}