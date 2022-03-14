package com.sampson.shoplist.dao

import android.app.Application
import com.sampson.shoplist.model.*
import com.sampson.shoplist.model.List
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module
import org.koin.dsl.single

class ShopApplication() : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ShopRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ShopRepository(database.shopDao()) }
}