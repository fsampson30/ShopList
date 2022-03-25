package com.sampson.shoplist.model

data class ItemsListCategory(
    var id: Int = 0,
    var item_code: Int = 0,
    var item_name: String = "",
    var list_code: String = "",
    var quantity: Int = 0,
    var category: Int = 0
)
