package com.sampson.shoplist.dao

import androidx.room.*
import com.sampson.shoplist.model.*
import com.sampson.shoplist.model.List
import com.sampson.shoplist.model.PopulateModel.populateCategory
import com.sampson.shoplist.model.PopulateModel.populateItem
import kotlinx.coroutines.flow.Flow


@Dao
interface ShopDao {

    @Query("SELECT * FROM table_item ORDER BY id")
    fun getAllItems(): Flow<MutableList<Item>>

    @Query("SELECT * FROM table_item WHERE name LIKE :text ORDER BY name")
    fun getItems(text: String): Flow<MutableList<Item>>

    @Query("SELECT * FROM table_item WHERE category = :id ORDER BY id")
    fun getItemsByCategory(id: Int): Flow<MutableList<Item>>

    @Query("SELECT * FROM table_category ORDER BY id")
    fun getAllCategories(): Flow<MutableList<Category>>

    @Query("SELECT l.id, l.list_code, max(l.shop_date) as shop_date, l.total_value, l.list_name  FROM table_list l")
    fun getLastShopInformation(): Flow<List>

    @Query("SELECT * FROM table_list ORDER BY id DESC")
    fun getAllLists(): Flow<MutableList<List>>

    @Query("SELECT l.id, l.item_code, l.item_name, l.list_code, l.quantity, i.category, cast('FALSE' as Boolean) as isDone FROM table_items_list l JOIN table_item i on l.item_code = i.id WHERE l.list_code = :param ORDER BY l.item_name")
    fun getListByCode(param: String): Flow<MutableList<ItemsListCategory>>

    @Query("SELECT 1 as id, tl.shop_date , 'AA' as list_code, tl.list_name, ( SELECT count(item_code) FROM table_items_list til     WHERE tl.list_code = til.list_code ) total_value FROM table_list tl")
    fun selectItemsHistoric() : Flow<MutableList<List>>

    @Query("SELECT 1 as id , '1' as shop_date  , 'aa' as list_code, li.item_name as list_name, SUM(li.quantity) as total_value FROM table_items_list li GROUP BY   li.item_name ORDER BY 4 ")
    fun selectItemsMostBought(): Flow<MutableList<List>>

    @Query("UPDATE table_list SET total_value = :value WHERE list_code = :code")
    suspend fun updateTotalValue(value : Double, code : String)

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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOneItemOnList(itemList: ItemsList)

    @Delete
    suspend fun deleteItem(item: Item)

    @Delete
    suspend fun deleteCategory(category: Category)


}