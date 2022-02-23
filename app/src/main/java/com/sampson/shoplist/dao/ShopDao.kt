package com.sampson.shoplist.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sampson.shoplist.model.Category
import com.sampson.shoplist.model.Item
import com.sampson.shoplist.model.PopulateModel
import com.sampson.shoplist.model.PopulateModel.populateCategory
import com.sampson.shoplist.model.PopulateModel.populateItem
import kotlinx.coroutines.flow.Flow


@Dao
interface ShopDao {

    @Query("SELECT * FROM table_item")
    fun getAllItems(): Flow<MutableList<Item>>

    @Query("SELECT * FROM table_item WHERE name LIKE :text")
    fun getItems(text: String): Flow<MutableList<Item>>

    @Query("SELECT * FROM table_item WHERE category = :id")
    fun getItemsByCategory(id: Int): Flow<MutableList<Item>>

    @Query("SELECT * FROM table_category")
    fun getAllCategories(): Flow<MutableList<Category>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllItems(items: MutableList<Item> = populateItem())

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllCategories(category: MutableList<Category> = populateCategory())

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: Item)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategory(category: Category)
}