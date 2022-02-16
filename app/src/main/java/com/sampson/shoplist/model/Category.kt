package com.sampson.shoplist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_category")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var category_name: String = ""
)
