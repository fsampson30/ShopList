package com.sampson.shoplist.viewmodel

import androidx.lifecycle.*
import com.sampson.shoplist.dao.ShopRepository
import com.sampson.shoplist.model.ItemsList
import com.sampson.shoplist.model.List
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ListViewModel(private val repository: ShopRepository) : ViewModel() {

    val selectItemsHistoric : LiveData<MutableList<List>> = repository.selectItemsHistoric.asLiveData()
    val selectItemsMostBought: LiveData<MutableList<List>> = repository.selectItemsMostBought.asLiveData()
    val allListsDesc: LiveData<MutableList<List>> = repository.allListsDesc.asLiveData()
    val allListsAsc: LiveData<MutableList<List>> = repository.allListsAsc.asLiveData()

    fun selectItemsByCode(param: String) = repository.selectItemsByCode(param).asLiveData()

    fun updateTotalValue(value : Double, code : String) = viewModelScope.launch{
        repository.updateTotalValue(value, code)
    }

    fun updateListItemIsDone(hash: String, id: Int) = viewModelScope.launch {
        repository.updateItemListIsDone(hash, id)
    }

    fun insertOneItemOnList(itemsList: ItemsList) = viewModelScope.launch {
        repository.insertOneItemOnList(itemsList)
    }


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