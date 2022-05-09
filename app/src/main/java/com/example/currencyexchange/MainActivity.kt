package com.example.currencyexchange

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyexchange.model.CurrenciesInSpecifiedDateModel
import com.example.currencyexchange.retrofit.FixerApiService
import com.example.currencyexchange.retrofit.ServiceBuilder
import com.example.currencyexchange.ui.fragments.MainFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

//        val compositeDisposable = CompositeDisposable()
//        compositeDisposable.add(ServiceBuilder.buildService()
//            .getFromDate()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe({response -> onResponse(response)}, {t-> onFailure(t)}))

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    private fun onFailure(t: Throwable?) {
        Toast.makeText(this,t?.message, Toast.LENGTH_SHORT).show()
    }

    private fun onResponse(response: CurrenciesInSpecifiedDateModel?) {

    }
}