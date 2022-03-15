package com.sampson.shoplist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_items_list")
data class ItemsList(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var item_code: Int = 0,
    var item_name: String = "",
    var list_code: Int = 0,
    var list_name: String = "",
    var quantity: Int = 0


)
