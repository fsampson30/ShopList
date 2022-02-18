package com.sampson.shoplist.dao

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ShopApplication() : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ShopRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ShopRepository(database.shopDao()) }
}