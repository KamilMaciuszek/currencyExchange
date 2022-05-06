package com.example.currencyexchange.model

import java.util.*

data class CurrenciesInSpecifiedDateModel(
    val base: String,
    val date: String,
    val listOfRates: List<String>
)