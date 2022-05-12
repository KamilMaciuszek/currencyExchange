package com.example.currencyexchange.ui.fragments

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyexchange.databinding.VerticalRvFragmentBinding
import com.example.currencyexchange.model.CurrenciesInSpecifiedDateModel
import com.example.currencyexchange.retrofit.RetrofitService
import com.example.currencyexchange.ui.recyclerview.VerticalRVAdapter
import com.example.currencyexchange.viewmodel.MainViewModel
import com.example.currencyexchange.viewmodel.MainViewModelFactory
import java.time.LocalDate
import java.time.temporal.ChronoUnit


@Suppress("DEPRECATION")
class MainFragment : Fragment() {
    private lateinit var verticalRvFragmentBinding: VerticalRvFragmentBinding

    private val retrofitService = RetrofitService.getInstance()
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        verticalRvFragmentBinding = VerticalRvFragmentBinding.inflate(inflater, container, false)
        return verticalRvFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(retrofitService)
        )[MainViewModel::class.java]

        val verticalRecyclerview = verticalRvFragmentBinding.rvVertical
        verticalRecyclerview.layoutManager = LinearLayoutManager(this.context)

        val dates = ArrayList<String>()
        val list: MutableList<CurrenciesInSpecifiedDateModel> =
            emptyList<CurrenciesInSpecifiedDateModel>().toMutableList()
        val amountOfDays = ChronoUnit.DAYS.between(LocalDate.parse("1999-01-01"), LocalDate.now())
        for (i in 0..amountOfDays) {
            dates.add(LocalDate.now().minusDays(i).toString())
        }

        val connMgr =
            activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {
            val adapter = VerticalRVAdapter(dates, viewModel, list)
            verticalRecyclerview.adapter = adapter
        } else {
            Toast.makeText(
                this.context,
                "Check internet connection and try again",
                Toast.LENGTH_LONG
            ).show()
        }

    }
}