package com.example.currencyexchange.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyexchange.model.CurrenciesInSpecifiedDateModel
import com.example.currencyexchange.retrofit.RetrofitService
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val apiService: RetrofitService) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val currenciesInSpecifiedDateModel = MutableLiveData<CurrenciesInSpecifiedDateModel>()

    fun fetchFromDate(date: String) {
        try {
            compositeDisposable.add(
                apiService.fetchFromDate(date)
                    .subscribeOn(Schedulers.io())
                    .subscribe {
                        currenciesInSpecifiedDateModel.postValue(it)
                    }
            )
        } catch (e: Exception) {
            Log.i("apiError", e.message.toString())
        }
    }
}