package com.sampson.shoplist.adapter

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.controller.ImageResources
import com.sampson.shoplist.model.ItemsListCategory

class ListDetailsAdapter(
    val context: Context,
    private val clickListener: ListDetailsAdapter.ItemClickListener
) : RecyclerView.Adapter<ListDetailsAdapter.ListDetailsViewHolder>() {

    var itemsList = mutableListOf<ItemsListCategory>()

    class ListDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgItem: ImageView = itemView.findViewById(R.id.imgListItemsCardPicture)
        val txtItemName: TextView = itemView.findViewById(R.id.txtListItemsCardItemName)
        val txtItemQuantity: TextView = itemView.findViewById(R.id.txtQttListItemsActivity)
        val cbbItemDone: CheckBox = itemView.findViewById(R.id.cbbItemDoneListItemsActivity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListDetailsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_items_card, parent, false)
        return ListDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListDetailsViewHolder, position: Int) {
        val currentItem = itemsList[position]

        holder.imgItem.setImageResource(ImageResources.getImageResource(currentItem.category))
        holder.txtItemName.text = currentItem.item_name
        holder.txtItemQuantity.text = currentItem.quantity.toString()

        holder.cbbItemDone.setOnCheckedChangeListener(null)
        holder.cbbItemDone.isChecked = currentItem.isDone

        holder.itemView.setOnClickListener {
            clickListener.itemOnClick(itemsList[position])
        }

        holder.cbbItemDone.setOnCheckedChangeListener { _, isChecked ->
            currentItem.isDone = !currentItem.isDone
            if(currentItem.isDone){
                holder.txtItemName.setTextColor(Color.GREEN)
                clickListener.itemOnClick(currentItem)
            } else {
                holder.txtItemName.setTextColor(context.resources.getColor(R.color.secondaryColor, context.theme))
                clickListener.itemOnClick(currentItem)
            }
        }

        if(currentItem.isDone){
            holder.txtItemName.setTextColor(Color.GREEN)
        } else
            holder.txtItemName.setTextColor(context.resources.getColor(R.color.secondaryColor, context.theme))
    }

    override fun getItemCount(): Int = itemsList.size

    fun submitList(list: MutableList<ItemsListCategory>) {
        this.itemsList = list
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun itemOnClick(item : ItemsListCategory)

    }
}