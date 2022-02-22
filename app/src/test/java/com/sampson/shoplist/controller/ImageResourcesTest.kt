package com.sampson.shoplist.controller

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ImageResourcesTest {

    private val image = ImageResources

    @Test(expected = NumberFormatException::class)
    fun getWrongNumber(){
        val input = -1
        image.getImageResource(input)
    }

}