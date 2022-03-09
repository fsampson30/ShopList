package com.sampson.shoplist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.model.Item
import com.sampson.shoplist.model.ItemsList

class CreateListAdapter(
    private val context: Context

) : RecyclerView.Adapter<CreateListAdapter.CreateListViewHolder>() {

    val itemsList = mutableListOf<ItemsList>()
    var item = Item()

    class CreateListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtItemName = itemView.findViewById<TextView>(R.id.txtCreateListItemCardAddedItemName)
        val edtQttItem = itemView.findViewById<EditText>(R.id.edtQttItemCreateListActivity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.create_list_item_card, parent, false)
        return CreateListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CreateListViewHolder, position: Int) {
        holder.txtItemName.text = itemsList[position].item_name
    }

    override fun getItemCount() = itemsList.size

    fun addItem(item : Item) {
        this.item = item
        itemsList.add(ItemsList(0,item.id,item.name,0,0))
        notifyDataSetChanged()
    }
}