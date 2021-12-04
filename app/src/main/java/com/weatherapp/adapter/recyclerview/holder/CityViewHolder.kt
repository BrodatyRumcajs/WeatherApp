package com.weatherapp.adapter.recyclerview.holder

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.weatherapp.adapter.recyclerview.item.CityItemViewModel

class CityViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemViewModel: CityItemViewModel) {
        binding.setVariable(BR.itemViewModel, itemViewModel)
    }
}
