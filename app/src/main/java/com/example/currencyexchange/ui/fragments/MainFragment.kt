package com.example.currencyexchange.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyexchange.databinding.VerticalCardviewBinding
import com.example.currencyexchange.databinding.VerticalRvFragmentBinding
import com.example.currencyexchange.ui.recyclerview.VerticalRVAdapter
import com.example.currencyexchange.viewmodel.MainViewModel
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.collections.ArrayList

class MainFragment : Fragment() {
    private lateinit var verticalRvFragmentBinding: VerticalRvFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

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

        val verticalRecyclerview = verticalRvFragmentBinding.rvVertical
        verticalRecyclerview.layoutManager = LinearLayoutManager(this.context)

        val data = ArrayList<String>()
        val amountOfDays = ChronoUnit.DAYS.between(LocalDate.parse("1999-01-01"),LocalDate.now())
        for (i in 0..10) {
            data.add(LocalDate.now().minusDays(i.toLong()).toString())
        }
        val adapter = VerticalRVAdapter(data)
        verticalRecyclerview.adapter = adapter
    }

}