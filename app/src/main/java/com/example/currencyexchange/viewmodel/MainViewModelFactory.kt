package com.example.currencyexchange.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.currencyexchange.retrofit.ApiRepository

class MainViewModelFactory constructor(private val apiRepository: ApiRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.apiRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}