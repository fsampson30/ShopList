package com.sampson.shoplist.viewmodel

import androidx.lifecycle.*
import com.sampson.shoplist.dao.ShopRepository
import com.sampson.shoplist.model.Item
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ItemViewModel(private val repository: ShopRepository) : ViewModel() {

    val allItems: LiveData<MutableList<Item>> = repository.allItems.asLiveData()

    fun insertItem(item: Item) = viewModelScope.launch {
        repository.insertItem(item)
    }

    fun selectItem(text: String) = repository.selectItem(text).asLiveData()

    fun selectItemByCategory(id: Int) = repository.selectItemByCategory(id).asLiveData()

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