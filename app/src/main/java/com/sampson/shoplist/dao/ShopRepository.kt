package com.sampson.shoplist.dao

import androidx.annotation.WorkerThread
import com.sampson.shoplist.model.*
import com.sampson.shoplist.model.List
import kotlinx.coroutines.flow.Flow

class ShopRepository(private val shopDao: ShopDao) {

    val allItems: Flow<MutableList<Item>> = shopDao.getAllItems()
    val allCategories: Flow<MutableList<Category>> = shopDao.getAllCategories()
    val lastShopInformation: Flow<List> = shopDao.getLastShopInformation()
    val allLists: Flow<MutableList<List>> = shopDao.getAllLists()

    @WorkerThread
    suspend fun insertItem(item: Item){
        shopDao.insertItem(item)
    }

    @WorkerThread
    suspend fun insertCategory(category: Category){
        shopDao.insertCategory(category)
    }

    @WorkerThread
    suspend fun insertList(list: List){
        shopDao.insertList(list)
    }

    @WorkerThread
    suspend fun insertListItems(listItems: MutableList<ItemsList>){
        shopDao.insertListItems(listItems)
    }

    fun selectItem(text: String) : Flow<MutableList<Item>>{
        return shopDao.getItems(text)
    }

    fun selectItemByCategory(id: Int) : Flow<MutableList<Item>>{
        return shopDao.getItemsByCategory(id)
    }

    fun selectItemsByCode(param: String) : Flow<MutableList<ItemsListCategory>>{
        return shopDao.getListByCode(param)
    }

    suspend fun deleteItem(item: Item){
        shopDao.deleteItem(item)
    }

    suspend fun deleteCategory(category: Category){
        shopDao.deleteCategory(category)
    }
}