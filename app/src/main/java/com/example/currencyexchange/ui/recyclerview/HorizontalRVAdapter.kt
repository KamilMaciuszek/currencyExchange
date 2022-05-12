package com.example.currencyexchange.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchange.databinding.HorizontalCardviewBinding

class HorizontalRVAdapter(private val dataSet: Map<String, Double>?) :
    RecyclerView.Adapter<HorizontalRVAdapter.ViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HorizontalCardviewBinding.inflate(inflater)
        return ViewHolder(binding, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rates = dataSet?.toList()?.map { "${it.first} : ${it.second}" }
        holder.textView.text = rates!![position]
    }

    override fun getItemCount(): Int {
        return dataSet!!.count()
    }

    class ViewHolder(binding: HorizontalCardviewBinding, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(binding.root) {
        val textView: TextView = binding.horizontalTv

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}