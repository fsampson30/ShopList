package com.sampson.shoplist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.sampson.shoplist.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgNewList: ImageView = findViewById(R.id.imgViewMainActivityNewList)
        val imgRetrieveList: ImageView = findViewById(R.id.imgViewMainActivityRetrieveList)
        val imgItems: ImageView = findViewById(R.id.imgViewMainActivityItems)
        val imgHistoric: ImageView = findViewById(R.id.imgViewMainActivityHistoric)
        val imgMarkets: ImageView = findViewById(R.id.imgViewMainActivityMarkets)

        imgNewList.setOnClickListener {
            Toast.makeText(this, "Testing new list",Toast.LENGTH_SHORT).show()
        }

        imgRetrieveList.setOnClickListener {
            Toast.makeText(this, "Testing retrieve list",Toast.LENGTH_SHORT).show()
        }

        imgItems.setOnClickListener {
            Toast.makeText(this, "Testing items",Toast.LENGTH_SHORT).show()
        }

        imgHistoric.setOnClickListener {
            Toast.makeText(this, "Testing historic",Toast.LENGTH_SHORT).show()
        }

        imgMarkets.setOnClickListener {
            Toast.makeText(this, "Testing markets",Toast.LENGTH_SHORT).show()
        }

    }
}