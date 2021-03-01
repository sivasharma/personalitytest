package com.personality.main.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CategoryViewModelFactory(
    private val networkRequestUseCase: CategoryUseCase
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            return CategoryViewModel(networkRequestUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}