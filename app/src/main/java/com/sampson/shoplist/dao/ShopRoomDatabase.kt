package com.sampson.shoplist.dao

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sampson.shoplist.model.Category
import com.sampson.shoplist.model.Item
import com.sampson.shoplist.model.ItemsList
import com.sampson.shoplist.model.List
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = arrayOf(Item::class, Category::class,ItemsList::class, List::class),
    version = 2,
    autoMigrations = [AutoMigration(from = 1, to = 2)],
    exportSchema = true
)

abstract class ShopRoomDatabase : RoomDatabase() {

    abstract fun shopDao(): ShopDao

    companion object {
        @Volatile
        private var INSTANCE: ShopRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ) : ShopRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, ShopRoomDatabase::class.java,
                    "shop_database"
                ).addCallback(ShopDataBaseCallback(scope)).build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class ShopDataBaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.shopDao())
                }
            }
        }

        suspend fun populateDatabase(shopDao: ShopDao){
            shopDao.insertAllItems()
            shopDao.insertAllCategories()
        }

    }
}


