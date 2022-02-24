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

    fun selectItem(text: String) : Flow<MutableList<Item>>{
        return shopDao.getItems(text)
    }

    fun selectItemByCategory(id: Int) : Flow<MutableList<Item>>{
        return shopDao.getItemsByCategory(id)
    }

    suspend fun deleteItem(item: Item){
        shopDao.deleteItem(item)
    }

    suspend fun deleteCategory(category: Category){
        shopDao.deleteCaterogy(category)
    }
}