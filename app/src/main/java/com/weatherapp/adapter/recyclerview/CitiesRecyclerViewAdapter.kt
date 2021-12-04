package com.weatherapp.adapter.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.weatherapp.adapter.recyclerview.diffutil.CityItemDiffCallback
import com.weatherapp.adapter.recyclerview.holder.CityViewHolder
import com.weatherapp.adapter.recyclerview.item.CityItemViewModel
import com.weatherapp.common.model.City
import com.weatherapp.databinding.ItemCityBinding
import javax.inject.Inject

class CitiesRecyclerViewAdapter @Inject constructor() : RecyclerView.Adapter<CityViewHolder>() {

    var onItemClickListener: ((View, City) -> Unit)? = null

    private val cities: MutableList<CityItemViewModel> = mutableListOf()

    fun update(cities: List<CityItemViewModel>) {
        val diffCallback = CityItemDiffCallback(this.cities, cities)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.cities.clear()
        this.cities.addAll(cities)

        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder =
        CityViewHolder(
            ItemCityBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cities[position].apply {
            clickAction = onItemClickListener
        })
    }

    override fun getItemCount(): Int = cities.size
}
