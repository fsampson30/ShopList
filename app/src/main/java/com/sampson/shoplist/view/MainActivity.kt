package com.sampson.shoplist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.sampson.shoplist.R
import com.sampson.shoplist.controller.DateUtils.getTodayDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgNewList: ImageView = findViewById(R.id.imgViewMainActivityNewList)
        val imgRetrieveList: ImageView = findViewById(R.id.imgViewMainActivityRetrieveList)
        val imgItems: ImageView = findViewById(R.id.imgViewMainActivityItems)
        val imgHistoric: ImageView = findViewById(R.id.imgViewMainActivityHistoric)
        val imgMarkets: ImageView = findViewById(R.id.imgViewMainActivityMarkets)

        val txtTodayDate : TextView = findViewById(R.id.txtMainActivityTodaysDate)

        txtTodayDate.text = getTodayDate()


        imgNewList.setOnClickListener {
            Toast.makeText(this, "Testing new list",Toast.LENGTH_SHORT).show()
        }

        imgRetrieveList.setOnClickListener {
            Toast.makeText(this, "Testing retrieve list",Toast.LENGTH_SHORT).show()
        }

        imgItems.setOnClickListener {
            val intent = Intent(baseContext,ItemsActivity::class.java)
            startActivity(intent)
        }

        imgHistoric.setOnClickListener {
            Toast.makeText(this, "Testing historic",Toast.LENGTH_SHORT).show()
        }

        imgMarkets.setOnClickListener {
            val intent = Intent(baseContext, MarketsActivity::class.java)
            startActivity(intent)
        }

    }
}