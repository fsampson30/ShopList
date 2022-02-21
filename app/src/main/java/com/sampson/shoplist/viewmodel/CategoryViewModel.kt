package com.sampson.shoplist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.sampson.shoplist.dao.ShopRepository
import com.sampson.shoplist.model.Category
import java.lang.IllegalArgumentException

class CategoryViewModel(private val repository: ShopRepository) : ViewModel() {

    val allCategories: LiveData<MutableList<Category>> = repository.allCategories.asLiveData()
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