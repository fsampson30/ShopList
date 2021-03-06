package com.sampson.shoplist.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.sampson.shoplist.R
import com.sampson.shoplist.model.Item

class CreateItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_item)

        val txtCreateItem: EditText = findViewById(R.id.edtCreateItemActivity)
        val spinner: Spinner = findViewById(R.id.spinnerCategoryCreateItem)
        val btnConfirm: Button = findViewById(R.id.btnCreateItemsActivityAddItem)

        var categoriesList = intent.getStringArrayListExtra("Categories")

        val arrayAdapter =
            categoriesList?.let {
                ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    it.toList()
                )
            }
        spinner.adapter = arrayAdapter

        Log.d("TESTING", categoriesList?.size.toString())

        btnConfirm.setOnClickListener {
            if (txtCreateItem.text.isEmpty()) {
                txtCreateItem.error = "Obrigatório"
            } else {
                val itemName = txtCreateItem.text.toString()
                val itemCategory = spinner.selectedItem.toString()
                val replyIntent = Intent()
                replyIntent.putExtra("itemName", itemName)
                replyIntent.putExtra("itemCategory", itemCategory)
                setResult(Activity.RESULT_OK, replyIntent)
                finish()
            }
        }
    }
}