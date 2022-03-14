package com.sampson.shoplist.controller

import kotlin.random.Random

object RandomUtils {

    fun returnRandomInt() : String {
        return Random.nextInt(100,100000).toString()
    }
}