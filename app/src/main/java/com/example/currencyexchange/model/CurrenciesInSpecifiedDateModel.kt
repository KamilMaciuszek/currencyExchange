package com.example.currencyexchange.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrenciesInSpecifiedDateModel(
    val base: String = "EUR",
    val date: String,
    val historical: Boolean,
    val rates: Map<String, Double>,
    val success: Boolean,
    val timestamp: String
)