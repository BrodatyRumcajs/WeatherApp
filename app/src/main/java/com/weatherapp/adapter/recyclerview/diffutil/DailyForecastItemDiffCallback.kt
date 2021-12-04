package com.weatherapp.adapter.recyclerview.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.weatherapp.adapter.recyclerview.item.DailyForecastItemViewModel

class DailyForecastItemDiffCallback(
    private val oldList: List<DailyForecastItemViewModel>,
    private val newList: List<DailyForecastItemViewModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].timeStamp == newList[newItemPosition].timeStamp

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].timeStamp == newList[newItemPosition].timeStamp
                && oldList[oldItemPosition].humidity == newList[newItemPosition].humidity
                && oldList[oldItemPosition].tempDay == newList[newItemPosition].tempDay
                && oldList[oldItemPosition].tempNight == newList[newItemPosition].tempNight
                && oldList[oldItemPosition].tempMorning == newList[newItemPosition].tempMorning
                && oldList[oldItemPosition].tempEvening == newList[newItemPosition].tempEvening
                && oldList[oldItemPosition].tempMin == newList[newItemPosition].tempMin
                && oldList[oldItemPosition].tempMax == newList[newItemPosition].tempMax
}
