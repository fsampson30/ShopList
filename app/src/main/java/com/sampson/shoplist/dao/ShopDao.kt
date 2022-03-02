package com.sampson.shoplist.dao

import androidx.room.*
import com.sampson.shoplist.model.Category
import com.sampson.shoplist.model.Item
import com.sampson.shoplist.model.PopulateModel
import com.sampson.shoplist.model.PopulateModel.populateCategory
import com.sampson.shoplist.model.PopulateModel.populateItem
import kotlinx.coroutines.flow.Flow


@Dao
interface ShopDao {

    @Query("SELECT * FROM table_item ORDER BY name")
    fun getAllItems(): Flow<MutableList<Item>>

    @Query("SELECT * FROM table_item WHERE name LIKE :text ORDER BY name")
    fun getItems(text: String): Flow<MutableList<Item>>

    @Query("SELECT * FROM table_item WHERE category = :id ORDER BY name")
    fun getItemsByCategory(id: Int): Flow<MutableList<Item>>

    @Query("SELECT * FROM table_category ORDER BY category_name")
    fun getAllCategories(): Flow<MutableList<Category>>

    @Query("SELECT id FROM table_category WHERE category_name LIKE :text")
    fun getCategoryIdByName(text: String): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllItems(items: MutableList<Item> = populateItem())

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllCategories(category: MutableList<Category> = populateCategory())

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: Item)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategory(category: Category)

    @Delete
    suspend fun deleteItem(item: Item)

    @Delete
    suspend fun deleteCategory(category: Category)
}