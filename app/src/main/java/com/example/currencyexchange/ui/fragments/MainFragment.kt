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

class MainFragment : Fragment() {
    private lateinit var verticalRvFragmentBinding: VerticalRvFragmentBinding
    private lateinit var verticalCardviewBinding: VerticalCardviewBinding

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
        for (i in 1..20) {
            data.add(i.toString())
        }
        val adapter = VerticalRVAdapter(data)
        verticalRecyclerview.adapter = adapter
    }

}