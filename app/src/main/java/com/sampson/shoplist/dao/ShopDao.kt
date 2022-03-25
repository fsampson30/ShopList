package com.sampson.shoplist.dao

import androidx.room.*
import com.sampson.shoplist.model.*
import com.sampson.shoplist.model.List
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

    @Query("SELECT l.id, l.list_code, max(l.shop_date) as shop_date, l.total_value, l.list_name  FROM table_list l")
    fun getLastShopInformation(): Flow<List>

    @Query("SELECT * FROM table_list ORDER BY id DESC")
    fun getAllLists(): Flow<MutableList<List>>

    @Query("SELECT l.id, l.item_code, l.item_name, l.list_code, l.quantity, i.category FROM table_items_list l JOIN table_item i on l.item_code = i.id WHERE l.list_code = :param ORDER BY l.item_name")
    fun getListByCode(param: String): Flow<MutableList<ItemsListCategory>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllItems(items: MutableList<Item> = populateItem())

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllCategories(category: MutableList<Category> = populateCategory())

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: Item)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategory(category: Category)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertList(list: List)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertListItems(listItems: MutableList<ItemsList>)

    @Delete
    suspend fun deleteItem(item: Item)

    @Delete
    suspend fun deleteCategory(category: Category)


}