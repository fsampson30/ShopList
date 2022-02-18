package com.sampson.shoplist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.sampson.shoplist.dao.ShopRepository
import com.sampson.shoplist.model.Item
import java.lang.IllegalArgumentException

class ItemViewModel(private val repository: ShopRepository) : ViewModel() {

    val allItems: LiveData<MutableList<Item>> = repository.allItems.asLiveData()
}

class ItemViewModelFactory(private val repository: ShopRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}