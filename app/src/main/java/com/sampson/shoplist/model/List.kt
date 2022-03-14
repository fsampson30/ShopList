package com.sampson.shoplist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_list")
data class List(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var shop_date : String = "",
    var list_code : String = "",
    var total_value: Double = 0.0
)
