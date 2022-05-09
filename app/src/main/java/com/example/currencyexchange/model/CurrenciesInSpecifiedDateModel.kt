package com.example.currencyexchange.model

data class CurrenciesInSpecifiedDateModel(
    val base: String = "EUR",
    val date: String,
    val historical : Boolean,
    val rates: List<String>,
    val success: Boolean,
    val timestamp: String
)