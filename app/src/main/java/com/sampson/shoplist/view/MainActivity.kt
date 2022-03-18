package com.sampson.shoplist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.sampson.shoplist.R
import com.sampson.shoplist.controller.DateUtils.getTodayDate
import com.sampson.shoplist.dao.ShopApplication
import com.sampson.shoplist.model.List
import com.sampson.shoplist.viewmodel.ListViewModel
import com.sampson.shoplist.viewmodel.ListViewModelFactory

class MainActivity : AppCompatActivity() {

    private val listViewModel: ListViewModel by viewModels {
        ListViewModelFactory((application as ShopApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgNewList: ImageView = findViewById(R.id.imgViewMainActivityNewList)
        val imgRetrieveList: ImageView = findViewById(R.id.imgViewMainActivityRetrieveList)
        val imgItems: ImageView = findViewById(R.id.imgViewMainActivityItems)
        val imgHistoric: ImageView = findViewById(R.id.imgViewMainActivityHistoric)
        val imgMarkets: ImageView = findViewById(R.id.imgViewMainActivityMarkets)

        val txtTodayDate: TextView = findViewById(R.id.txtMainActivityTodaysDate)
        val txtLastShopDate: TextView = findViewById(R.id.txtMainActivityLastShopDate)
        val txtLastShopValue: TextView = findViewById(R.id.txtMainActivityLastShopValue)


        txtTodayDate.text = getTodayDate()

        listViewModel.lastShopInformation.observe(this) { last ->
            last.let {
                txtLastShopDate.text = it.shop_date
                txtLastShopValue.text = it.total_value.toString()
            }
        }

        imgNewList.setOnClickListener {
            val intent = Intent(baseContext, CreateListActivity::class.java)
            startActivity(intent)
        }

        imgRetrieveList.setOnClickListener {
            Toast.makeText(this, "Testing retrieve list", Toast.LENGTH_SHORT).show()
        }

        imgItems.setOnClickListener {
            val intent = Intent(baseContext, ItemsActivity::class.java)
            startActivity(intent)
        }

        imgHistoric.setOnClickListener {
            Toast.makeText(this, "Testing historic", Toast.LENGTH_SHORT).show()
        }

        imgMarkets.setOnClickListener {
            val intent = Intent(baseContext, MarketsActivity::class.java)
            startActivity(intent)
        }

    }
}