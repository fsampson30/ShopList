package com.sampson.shoplist.view

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.CategoryAdapter
import com.sampson.shoplist.adapter.ItemAdapter
import com.sampson.shoplist.model.PopulateModel

class ItemsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val btnAddItem: Button = findViewById(R.id.btnItemsActivityAddItem)
        val btnAddCategory: Button = findViewById(R.id.btnItemsActivityAddCategory)

        val category = PopulateModel().populateCategory()
        val items = PopulateModel().populateItem()

        val categoryAdapter = CategoryAdapter(baseContext, category)
        val rvCategory: RecyclerView = findViewById(R.id.rvItemActivityCategory)
        rvCategory.adapter = categoryAdapter

        val itemAdapter = ItemAdapter(baseContext, items)
        val rvItem: RecyclerView = findViewById(R.id.rvItemActivityItems)
        rvItem.adapter = itemAdapter

        btnAddItem.setOnClickListener {
            val input = EditText(this).apply {
                hint = "Adicionar item..."
                inputType = InputType.TYPE_CLASS_TEXT
            }
            AlertDialog.Builder(this).apply {
                setView(input)
                setNegativeButton("Cancel", null)
                setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                    if (input.text.isEmpty()) {
                        return@OnClickListener
                    } else {
                        Toast.makeText(context, input.text.toString(), Toast.LENGTH_SHORT).show()
                    }
                }).show()
            }
        }

        btnAddCategory.setOnClickListener {
            val input = EditText(this).apply {
                hint = "Adicionar categoria..."
                inputType = InputType.TYPE_CLASS_TEXT
            }
            AlertDialog.Builder(this).apply {
                setView(input)
                setNegativeButton("Cancel", null)
                setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                    if (input.text.isEmpty()) {
                        return@OnClickListener
                    } else {
                        Toast.makeText(context, input.text.toString(), Toast.LENGTH_SHORT).show()
                    }
                })
            }.show()
        }
    }
}