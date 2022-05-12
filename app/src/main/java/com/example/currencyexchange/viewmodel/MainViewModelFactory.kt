package com.example.currencyexchange.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.currencyexchange.retrofit.RetrofitService

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory constructor(private val apiService: RetrofitService) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.apiService) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}