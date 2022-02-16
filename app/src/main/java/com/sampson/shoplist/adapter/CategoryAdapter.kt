package com.sampson.shoplist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.model.Category


class CategoryAdapter(
    private val context: Context,
    private var categories: ArrayList<Category>

) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtCategory: TextView = itemView.findViewById(R.id.txtCategoryCardName)
        val imgCategory: ImageView = itemView.findViewById(R.id.imgCategoryCardPicture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_card,parent,false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.txtCategory.text = categories[position].category_name
    }

    override fun getItemCount() = categories.size
}