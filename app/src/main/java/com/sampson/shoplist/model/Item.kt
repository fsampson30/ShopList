package com.sampson.shoplist.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "table_item")
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var name: String = "",
    var category: Int = 0
) : Serializable
