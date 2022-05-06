package com.sampson.shoplist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_items_list")
data class ItemsList(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var item_code: Int = 0,
    var item_name: String = "",
    var list_code: String = "",
    var quantity: Int = 0,
    @ColumnInfo(name = "isDone", defaultValue = "false") var isDone: Boolean = false
)
