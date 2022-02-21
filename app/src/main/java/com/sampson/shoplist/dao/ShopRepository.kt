package com.sampson.shoplist.dao

import androidx.annotation.WorkerThread
import com.sampson.shoplist.model.Category
import com.sampson.shoplist.model.Item
import kotlinx.coroutines.flow.Flow

class ShopRepository(private val shopDao: ShopDao) {

    val allItems: Flow<MutableList<Item>> = shopDao.getAllItems()
    val allCategories: Flow<MutableList<Category>> = shopDao.getAllCategories()

    @WorkerThread
    suspend fun insertItem(item: Item){
        shopDao.insertItem(item)
    }

    suspend fun insertCategory(category: Category){
        shopDao.insertCategory(category)
    }
}