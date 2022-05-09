package com.example.currencyexchange.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchange.databinding.VerticalCardviewBinding

class VerticalRVAdapter(private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<VerticalRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VerticalCardviewBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = dataSet[position]
        holder.textView.text = itemsViewModel
        val horizontalLayoutManager = LinearLayoutManager(
            holder.horizontalRecyclerView.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        horizontalLayoutManager.initialPrefetchItemCount = 4

        holder.horizontalRecyclerView.apply {
            val array : ArrayList<String> = ArrayList()
            for (i in 0..20){
                array.add(i.toString())
            }
            layoutManager = horizontalLayoutManager
            adapter = HorizontalRVAdapter(array)
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(binding: VerticalCardviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val horizontalRecyclerView: RecyclerView = binding.horizontalRv
        val textView: TextView = binding.textView
    }


}