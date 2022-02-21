package com.sampson.shoplist.viewmodel

import androidx.lifecycle.*
import com.sampson.shoplist.dao.ShopRepository
import com.sampson.shoplist.model.Category
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class CategoryViewModel(private val repository: ShopRepository) : ViewModel() {

    val allCategories: LiveData<MutableList<Category>> = repository.allCategories.asLiveData()

    fun insertCategory(category: Category) = viewModelScope.launch{
        repository.insertCategory(category)
    }
}

class CategoryViewModelFactory(private val repository: ShopRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CategoryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}