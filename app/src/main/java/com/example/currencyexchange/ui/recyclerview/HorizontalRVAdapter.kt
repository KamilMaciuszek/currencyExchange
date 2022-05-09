package com.example.currencyexchange.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchange.databinding.HorizontalCardviewBinding

class HorizontalRVAdapter(private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<HorizontalRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HorizontalCardviewBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = dataSet[position]
        holder.textView.text = items
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(binding: HorizontalCardviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView: TextView = binding.horizontalTv
    }
}