package com.example.currencyexchange.model

data class CurrenciesInSpecifiedDateModel(
    val base: String,
    val date: String,
    val listOfRates: List<String>
)