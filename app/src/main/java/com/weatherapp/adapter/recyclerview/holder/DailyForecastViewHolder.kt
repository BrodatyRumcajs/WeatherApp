package com.weatherapp.adapter.recyclerview.holder

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.weatherapp.adapter.recyclerview.item.DailyForecastItemViewModel

class DailyForecastViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemViewModel: DailyForecastItemViewModel) {
        binding.setVariable(BR.itemViewModel, itemViewModel)
    }
}
