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
                2 -> R.drawable.drinks
                3 -> R.drawable.biscuits
                4 -> R.drawable.cereal
                5 -> R.drawable.frozen
                6 -> R.drawable.caned
                7 -> R.drawable.flour
                8 -> R.drawable.hygiene
                9 -> R.drawable.vegetal
                10 -> R.drawable.milk
                11 -> R.drawable.cleaning
                12 -> R.drawable.massas
                13 -> R.drawable.breakfast
                14 -> R.drawable.oils
                15 -> R.drawable.bread
                16 -> R.drawable.fish
                17 -> R.drawable.salty
                18 -> R.drawable.spices
                19 -> R.drawable.utils
                else -> R.drawable.others
            }
        }
    }
}