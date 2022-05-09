package com.example.currencyexchange.retrofit

import com.example.currencyexchange.model.CurrenciesInSpecifiedDateModel
import com.squareup.moshi.Moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import kotlin.coroutines.coroutineContext

private var myCompositeDisposable: CompositeDisposable? = null

private val moshi = Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

object ServiceBuilder {
    private val client = OkHttpClient
        .Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://api.apilayer.com/fixer/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(FixerApiService::class.java)

    fun buildService(): FixerApiService{
        return retrofit
    }
}



interface FixerApiService {
    @Headers("apikey: " + "l5wFqdzqPMbNEaAqkgrMfAhAHW4ZOQ2S")
    @GET("{date}")
    fun getFromDate() : Observable<CurrenciesInSpecifiedDateModel>
}

