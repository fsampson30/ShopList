package com.sampson.shoplist.controller

import com.sampson.shoplist.R
import java.lang.NumberFormatException

object ImageResources {

    fun getImageResource(position: Int): Int {
        if (position < 0) {
            throw NumberFormatException()
        } else {
            return when (position) {
                1 -> R.drawable.meat
                2 -> R.drawable.cereal
                3 -> R.drawable.drinks
                4 -> R.drawable.milk
                5 -> R.drawable.flour
                6 -> R.drawable.spices
                7 -> R.drawable.bread
                8 -> R.drawable.fish
                9 -> R.drawable.cleaning
                else -> R.drawable.others
            }
        }
    }
}