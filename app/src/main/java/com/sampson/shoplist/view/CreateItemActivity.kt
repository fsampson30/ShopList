package com.sampson.shoplist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.activity.viewModels
import com.sampson.shoplist.R
import com.sampson.shoplist.dao.ShopApplication
import com.sampson.shoplist.model.Item
import com.sampson.shoplist.viewmodel.ItemViewModel
import com.sampson.shoplist.viewmodel.ItemViewModelFactory


class CreateItemActivity : AppCompatActivity() {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((application as ShopApplication).repository)
    }

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
                Toast.makeText(this, "Confirmando", Toast.LENGTH_SHORT).show()
                val item = Item(0, txtCreateItem.text.toString(), spinner.selectedItemPosition+1)
                itemViewModel.insertItem(item)
                finish()
            }

        }


    }
}