package com.sampson.shoplist.controller

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun getTodayDate() : String{
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        return sdf.format(Date())
    }
}