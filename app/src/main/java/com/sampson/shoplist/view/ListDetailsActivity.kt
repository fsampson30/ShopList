package com.sampson.shoplist.view

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.ListDetailsAdapter
import com.sampson.shoplist.dao.ShopApplication
import com.sampson.shoplist.model.Item
import com.sampson.shoplist.model.ItemsList
import com.sampson.shoplist.model.ItemsListCategory
import com.sampson.shoplist.viewmodel.ListViewModel
import com.sampson.shoplist.viewmodel.ListViewModelFactory

class ListDetailsActivity : AppCompatActivity() {

    private val listViewModel: ListViewModel by viewModels {
        ListViewModelFactory((application as ShopApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_details)

        val param = intent.extras?.get("code") as String
        val value = intent.extras?.get("totalValue") as Double

        val rvListItems: RecyclerView = findViewById(R.id.rvShowItemsListDetailsActivity)
        val btnSubmitValue: Button = findViewById(R.id.btnSubmitTotalValueListDetailsActivity)
        val txtTotalValue: TextView = findViewById(R.id.lblShowTotalValueListDetailsActivity)
        val btnAddItem: Button = findViewById(R.id.btnAddItemListDetailsActivity)

        val itemsAdapter = ListDetailsAdapter(baseContext, object : ListDetailsAdapter.ItemClickListener {
            override fun itemOnClick(item: ItemsListCategory) {
                listViewModel.updateListItemIsDone(item.list_code,item.item_code)
                Log.d("FLAVIO", item.list_code +  item.item_code.toString())
            }
        })

        rvListItems.adapter = itemsAdapter

        listViewModel.selectItemsByCode(param).observe(this) { items ->
            items.let { itemsAdapter.submitList(it) }
        }

        "Valor total da compra: ${value.toString()}".also { txtTotalValue.text = it }

        val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val itemName = it.data?.getStringExtra("itemName") as String
                val itemCode = it.data?.getIntExtra("itemCode",0) as Int
                val itemQtt = it.data?.getIntExtra("itemQtt",0) as Int
                val itemToInsert = ItemsList(0,itemCode,itemName,param,itemQtt)
                listViewModel.insertOneItemOnList(itemToInsert)
            }
            listViewModel.selectItemsByCode(param).observe(this) { items ->
                items.let { itemsAdapter.submitList(it) }
            }
        }

        btnAddItem.setOnClickListener {
            val intent = Intent(baseContext, AddItemToListActivity::class.java)
            register.launch(intent)
        }

        btnSubmitValue.setOnClickListener {
            val input = EditText(this).apply {
                hint = "Valor da compra..."
                inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL
            }
            AlertDialog.Builder(this).apply {
                setView(input)
                setNegativeButton("Cancel", null)
                setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                    if (input.text.isEmpty()) {
                        return@OnClickListener
                    } else {
                        listViewModel.updateTotalValue(input.text.toString().toDouble(), param)
                        Toast.makeText(baseContext, "Valor atualizado.", Toast.LENGTH_SHORT).show()
                        val inputManager: InputMethodManager = getSystemService(
                            INPUT_METHOD_SERVICE
                        ) as InputMethodManager
                        inputManager.hideSoftInputFromWindow(input.windowToken, 0)
                        txtTotalValue.text = "Valor total da compra: ${input.text.toString()}"
                    }
                })
            }.show()
        }
    }
}