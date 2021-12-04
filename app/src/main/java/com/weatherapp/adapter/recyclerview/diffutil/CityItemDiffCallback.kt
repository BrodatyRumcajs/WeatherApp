package com.weatherapp.adapter.recyclerview.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.weatherapp.adapter.recyclerview.item.CityItemViewModel

class CityItemDiffCallback(
    private val oldList: List<CityItemViewModel>,
    private val newList: List<CityItemViewModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].city == newList[newItemPosition].city

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].city.name == newList[newItemPosition].city.name
                && oldList[oldItemPosition].city.country == newList[newItemPosition].city.country
                && oldList[oldItemPosition].city.state == newList[newItemPosition].city.state
}
