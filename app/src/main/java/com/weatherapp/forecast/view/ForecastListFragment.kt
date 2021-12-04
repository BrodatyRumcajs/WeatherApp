package com.weatherapp.forecast.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.distinctUntilChanged
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.weatherapp.R
import com.weatherapp.adapter.recyclerview.DailyForecastsRecyclerViewAdapter
import com.weatherapp.databinding.FragmentForecastListBinding
import com.weatherapp.forecast.viewmodel.ForecastListViewModel
import com.weatherapp.search.args.SEARCH_CITY_RESULT_KEY
import com.weatherapp.search.args.SearchCityResult
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ForecastListFragment : Fragment() {

    @Inject
    lateinit var recyclerViewAdapter: DailyForecastsRecyclerViewAdapter

    private val forecastListViewModel by viewModels<ForecastListViewModel>()
    private var binding: FragmentForecastListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        return FragmentForecastListBinding.inflate(inflater, container, false).apply {
            adapter = recyclerViewAdapter
            viewModel = forecastListViewModel
            lifecycleOwner = viewLifecycleOwner
        }.also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpToolbar(view)
        setUpMenu()
        setUpSwipeRefreshLayout()
        observeSearchResult()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun setUpToolbar(view: View) {
        val navController = Navigation.findNavController(view)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        getToolbar()?.setupWithNavController(navController, appBarConfiguration)
    }

    private fun setUpMenu() {
        getToolbar()?.apply {
            inflateMenu(R.menu.menu_search)
            setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.searchItem -> onSearchItemClick()
                    else -> Unit
                }
                return@setOnMenuItemClickListener true
            }
        }
    }

    private fun setUpSwipeRefreshLayout() {
        getSwipeRefreshLayout()?.apply {
            setOnRefreshListener {
                forecastListViewModel.getForecast()
            }
        }
    }

    private fun observeSearchResult() {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<SearchCityResult>(
            SEARCH_CITY_RESULT_KEY
        )?.distinctUntilChanged()?.observe(viewLifecycleOwner) { searchCityResult ->
            forecastListViewModel.selectCity(searchCityResult)
        }
    }

    private fun onSearchItemClick() {
        findNavController().navigate(ForecastListFragmentDirections.actionForecastListFragmentToSearchCityFragment())
    }

    private fun getToolbar() = binding?.toolbar

    private fun getSwipeRefreshLayout() = binding?.swipeRefreshLayout
}
