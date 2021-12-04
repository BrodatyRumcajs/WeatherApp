package com.weatherapp.adapter.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.weatherapp.adapter.recyclerview.diffutil.DailyForecastItemDiffCallback
import com.weatherapp.adapter.recyclerview.holder.DailyForecastViewHolder
import com.weatherapp.adapter.recyclerview.item.DailyForecastItemViewModel
import com.weatherapp.databinding.ItemDailyForecastBinding
import javax.inject.Inject

class DailyForecastsRecyclerViewAdapter @Inject constructor() : RecyclerView.Adapter<DailyForecastViewHolder>() {

    private val dailyForecasts: MutableList<DailyForecastItemViewModel> = mutableListOf()

    fun update(dailyForecasts: List<DailyForecastItemViewModel>) {
        val diffCallback = DailyForecastItemDiffCallback(this.dailyForecasts, dailyForecasts)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.dailyForecasts.clear()
        this.dailyForecasts.addAll(dailyForecasts)

        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyForecastViewHolder =
        DailyForecastViewHolder(
            ItemDailyForecastBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: DailyForecastViewHolder, position: Int) {
        holder.bind(dailyForecasts[position])
    }

    override fun getItemCount(): Int = dailyForecasts.size
}
