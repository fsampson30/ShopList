package com.sampson.shoplist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.model.Item
import com.sampson.shoplist.model.ItemsList

class CreateListAdapter(
    private val context: Context

) : RecyclerView.Adapter<CreateListAdapter.CreateListViewHolder>() {

    var itemsList = mutableListOf<ItemsList>()
    var item = Item()

    class CreateListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtItemName = itemView.findViewById<TextView>(R.id.txtCreateListItemCardAddedItemName)
        val txtQttItem = itemView.findViewById<TextView>(R.id.edtQttItemCreateListActivity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateListViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.create_list_item_card, parent, false)
        return CreateListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CreateListViewHolder, position: Int) {
        holder.txtItemName.text = itemsList[position].item_name
        holder.txtQttItem.text = itemsList[position].quantity.toString()
    }

    override fun getItemCount() = itemsList.size

    fun addItem(item: Item, listHash: String) {
        this.item = item
        val currentItemList = ItemsList(0, item.id, item.name, listHash, 0)

        if (itemsList.isEmpty()) {
            itemsList.add(currentItemList)
            notifyDataSetChanged()
        } else {
            if (!itemsList.contains(currentItemList)) {
                itemsList.add(currentItemList)
                notifyDataSetChanged()
            }
        }
    }

    fun removeItem(position: Int) {
        if (itemsList[position].quantity > 0) {
            itemsList[position].quantity--
            notifyItemChanged(position)
        } else {
            itemsList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun removeAllItems() {
        itemsList.clear()
        notifyDataSetChanged()
    }

    fun addQuantity(position: Int) {
        itemsList[position].quantity++
        notifyItemChanged(position)
    }

    fun retrieveItemsList() : MutableList<ItemsList>{
        return itemsList
    }

}