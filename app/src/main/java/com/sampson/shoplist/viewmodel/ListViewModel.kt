package com.sampson.shoplist.viewmodel

import androidx.lifecycle.*
import com.sampson.shoplist.dao.ShopRepository
import com.sampson.shoplist.model.ItemsList
import com.sampson.shoplist.model.List
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ListViewModel(private val repository: ShopRepository) : ViewModel() {

    val lastShopInformation : LiveData<List> = repository.lastShopInformation.asLiveData()

    fun insertList(list: List) = viewModelScope.launch {
        repository.insertList(list)
    }

    fun insertItemsList(list: MutableList<ItemsList>) = viewModelScope.launch {
        repository.insertListItems(list)
    }

}

class ListViewModelFactory(private val repository: ShopRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}