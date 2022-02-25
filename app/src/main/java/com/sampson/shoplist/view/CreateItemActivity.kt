package com.sampson.shoplist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import com.sampson.shoplist.R


class CreateItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_item)

        val txtCreateItem : EditText = findViewById(R.id.edtCreateItemActivity)
        val spinner: Spinner = findViewById(R.id.spinnerCategoryCreateItem)

        var categoriesList = intent.getStringArrayListExtra("Categories")

        val arrayAdapter =
            categoriesList?.let { ArrayAdapter(this, android.R.layout.simple_list_item_1, it.toList()) }
        spinner.adapter = arrayAdapter

        Log.d("TESTING", categoriesList?.size.toString())



    }
}