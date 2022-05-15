package com.example.currencyexchange.retrofit

import com.example.currencyexchange.model.CurrenciesInSpecifiedDateModel
import com.squareup.moshi.Moshi.Builder
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

private val moshi = Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface RetrofitService {
    @Headers("apikey:" + "QQ6j0B4hJdf4fctQBPNfD5pxWA58oYsZ")
    @GET("{date}")
    fun fetchFromDate(@Path("date") date: String): Observable<CurrenciesInSpecifiedDateModel>

    companion object {
        private const val BASE_URL = "https://api.apilayer.com/fixer/"
        private var retrofitService: RetrofitService? = null
        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        private val client = OkHttpClient.Builder()
            .apply {
                this.addInterceptor(interceptor)
            }
            .readTimeout(100, java.util.concurrent.TimeUnit.SECONDS)
            .connectTimeout(100, java.util.concurrent.TimeUnit.SECONDS)
            .build()

        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .baseUrl(BASE_URL)
                    .client(client)
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
}






