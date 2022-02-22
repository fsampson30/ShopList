package com.sampson.shoplist.controller

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DateUtilsTest {
    private val date = DateUtils

    @Test
    fun getDate(){
        val input = "15/02/2022"
        val expected = date.getTodayDate()
        assertEquals(input,expected)
    }

}