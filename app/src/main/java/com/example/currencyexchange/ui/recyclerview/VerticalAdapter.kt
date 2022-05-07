package com.example.currencyexchange.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchange.databinding.VerticalRvBinding

class VerticalAdapter(private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<VerticalAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VerticalRvBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = dataSet[position]
        holder.textView.text = itemsViewModel
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(binding: VerticalRvBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView: TextView = binding.textView
    }
}