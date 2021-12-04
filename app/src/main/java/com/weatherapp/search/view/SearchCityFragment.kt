package com.weatherapp.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.weatherapp.adapter.recyclerview.CitiesRecyclerViewAdapter
import com.weatherapp.common.util.showSoftKeyboard
import com.weatherapp.databinding.FragmentSearchCityBinding
import com.weatherapp.search.args.SEARCH_CITY_RESULT_KEY
import com.weatherapp.search.args.SearchCityResult
import com.weatherapp.search.viewmodel.SearchCityViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchCityFragment : Fragment() {

    @Inject
    lateinit var recyclerViewAdapter: CitiesRecyclerViewAdapter

    private val searchCityViewModel by viewModels<SearchCityViewModel>()
    private var binding: FragmentSearchCityBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSearchCityBinding.inflate(inflater, container, false).apply {
            adapter = recyclerViewAdapter
            viewModel = searchCityViewModel
            lifecycleOwner = viewLifecycleOwner
        }.also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpToolbar(view)
        setUpSearchView()
        setUpSwipeRefreshLayout()
        setUpRecyclerViewAdapter()
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

    private fun setUpSearchView() {
        getSearchView()?.apply {
            setOnQueryTextFocusChangeListener { view, _ ->
                view.findFocus()?.let { focusedView ->
                    post {
                        showSoftKeyboard(focusedView)
                    }
                }
            }
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    onSearchClick(query)
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
            getSearchCloseButton()?.let { closeButton ->
                closeButton.setOnClickListener {
                    searchCityViewModel.clearResults()
                    setQuery("", false)
                }
            }
            requestFocus()
        }
    }

    private fun setUpSwipeRefreshLayout() {
        getSwipeRefreshLayout()?.apply {
            setOnRefreshListener {
                searchCityViewModel.searchCity()
            }
        }
    }

    private fun setUpRecyclerViewAdapter() {
        recyclerViewAdapter.onItemClickListener = { view, city ->
            view.findNavController().apply {
                with(city) {
                    previousBackStackEntry?.savedStateHandle?.set(
                        SEARCH_CITY_RESULT_KEY,
                        SearchCityResult(name, latitude, longitude)
                    )
                }
                navigateUp()
            }
        }
    }

    private fun onSearchClick(query: String?) {
        searchCityViewModel.cityName.value = query
    }

    private fun getToolbar() = binding?.toolbar

    private fun getSearchView() = binding?.searchView
    private fun getSearchCloseButton() =
        getSearchView()?.findViewById<View>(androidx.appcompat.R.id.search_close_btn)

    private fun getSwipeRefreshLayout() = binding?.swipeRefreshLayout
}
