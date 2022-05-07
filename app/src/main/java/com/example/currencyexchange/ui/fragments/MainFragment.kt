package com.example.currencyexchange.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyexchange.databinding.MainFragmentBinding
import com.example.currencyexchange.ui.recyclerview.VerticalAdapter
import com.example.currencyexchange.viewmodel.MainViewModel

class MainFragment : Fragment() {
    private lateinit var binding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = binding.rvVertical
        print(recyclerview.toString())
        recyclerview.layoutManager = LinearLayoutManager(this.context)

        val data = ArrayList<String>()
        for (i in 1..20) {
            data.add(i.toString())
        }
        val adapter = VerticalAdapter(data)
        recyclerview.adapter = adapter
    }

}