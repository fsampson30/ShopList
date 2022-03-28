package com.sampson.shoplist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.sampson.shoplist.R
import com.sampson.shoplist.adapter.ListDetailsAdapter
import com.sampson.shoplist.dao.ShopApplication
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
        val edtTotalValue: EditText = findViewById(R.id.edtTotalValueListDetailsActivity)
        val btnSubmitValue: Button = findViewById(R.id.btnSubmitTotalValueListDetailsActivity)

        edtTotalValue.setText(value.toString(), TextView.BufferType.EDITABLE)


        val itemsAdapter = ListDetailsAdapter(baseContext)
        rvListItems.adapter = itemsAdapter

        listViewModel.selectItemsByCode(param).observe(this) { items ->
            items.let { itemsAdapter.submitList(it) }
        }

        btnSubmitValue.setOnClickListener {
            val totalValue = edtTotalValue.text.toString().toDouble()
            if (totalValue==0.0){
                edtTotalValue.error = "Valor zerado"
            } else {
                listViewModel.updateTotalValue(totalValue,param)
                Toast.makeText(baseContext,"Valor atualizado.",Toast.LENGTH_SHORT).show()
                val inputManager: InputMethodManager = getSystemService(
                    INPUT_METHOD_SERVICE
                ) as InputMethodManager
                inputManager.hideSoftInputFromWindow(edtTotalValue.windowToken, 0)
            }
        }

        val helperPaintTextView =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    Toast.makeText(baseContext,"TEST",Toast.LENGTH_SHORT).show()
                }

            }

        val helperPaint = ItemTouchHelper(helperPaintTextView)
        helperPaint.attachToRecyclerView(rvListItems)
    }
}