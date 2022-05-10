package com.example.currencyexchange.retrofit

class ApiRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllCurrencies(date: String) = retrofitService.fetchFromDate(date)
}