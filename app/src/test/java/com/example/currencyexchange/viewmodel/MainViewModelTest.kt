package com.example.currencyexchange.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.currencyexchange.Rules
import com.example.currencyexchange.model.CurrenciesInSpecifiedDateModel
import com.example.currencyexchange.retrofit.RetrofitService
import io.reactivex.Observable
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {
    @Mock
    private lateinit var service: RetrofitService

    private lateinit var mainViewModel: MainViewModel


    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    companion object {
        @ClassRule
        @JvmField
        val schedulers = Rules()
    }


    @Before
    fun init() {
        mainViewModel = MainViewModel(service)
    }


    @Test
    fun fetchFromDate() {
        val date = "2022-05-05"

        Mockito.`when`(service.fetchFromDate(date))
            .thenReturn(
                Observable.just(
                    CurrenciesInSpecifiedDateModel(
                        "EUR",
                        date,
                        true,
                        emptyMap(),
                        true,
                        "123"
                    )
                )
            )

        mainViewModel.fetchFromDate(date)

        assert(mainViewModel.currenciesInSpecifiedDateModel.value!!.date == date)
        assert(mainViewModel.currenciesInSpecifiedDateModel.value!!.timestamp == "123")
    }
}