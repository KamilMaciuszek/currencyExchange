package com.example.currencyexchange.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyexchange.model.CurrenciesInSpecifiedDateModel
import com.example.currencyexchange.retrofit.ApiRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val apiRepository: ApiRepository) : ViewModel() {
    val error = MutableLiveData<String>()
    val currenciesInSpecifiedDateModel = MutableLiveData<CurrenciesInSpecifiedDateModel>()

    fun fetchFromDate(date: String) {
        val response = apiRepository.getAllCurrencies(date)
        response.enqueue(object : Callback<CurrenciesInSpecifiedDateModel> {

            override fun onResponse(
                call: Call<CurrenciesInSpecifiedDateModel>,
                response: Response<CurrenciesInSpecifiedDateModel>
            ) {
                currenciesInSpecifiedDateModel.postValue(response.body())
            }

            override fun onFailure(call: Call<CurrenciesInSpecifiedDateModel>, t: Throwable) {
                error.postValue(t.message)
            }
        })
    }

}