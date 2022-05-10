package com.example.currencyexchange.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchange.databinding.VerticalCardviewBinding
import com.example.currencyexchange.ui.fragments.MainFragmentDirections
import com.example.currencyexchange.viewmodel.MainViewModel

class VerticalRVAdapter(
    private val dates: ArrayList<String>,
    private val viewModel: MainViewModel
) :
    RecyclerView.Adapter<VerticalRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VerticalCardviewBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = dates[position]
        holder.textView.text = itemsViewModel
        val horizontalLayoutManager = LinearLayoutManager(
            holder.horizontalRecyclerView.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        var rates: Map<String, Double>?

        holder.horizontalRecyclerView.apply {
            viewModel.fetchFromDate(dates[position])
            layoutManager = horizontalLayoutManager
            viewModel.currenciesInSpecifiedDateModel.observe(
                holder.horizontalRecyclerView.context as LifecycleOwner
            ) {
                rates = it.rates
                val horizontalAdapter = HorizontalRVAdapter(rates)
                horizontalAdapter.setOnItemClickListener(object :
                    HorizontalRVAdapter.OnItemClickListener {
                    override fun onItemClick(position: Int) {
                        val action = MainFragmentDirections.actionMainFragmentToDetailsFragment()
                        findNavController().navigate(action)
                    }
                })
                adapter = horizontalAdapter

            }
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }
    }

    override fun getItemCount(): Int {
        return dates.size
    }

    class ViewHolder(binding: VerticalCardviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val horizontalRecyclerView: RecyclerView = binding.horizontalRv
        val textView: TextView = binding.textView
    }


}