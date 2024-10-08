package com.example.languagemap.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.languagemap.MainActivity
import com.example.languagemap.R
import com.example.languagemap.adapter.HomeAdapter
import com.example.languagemap.data.initWordsList
import com.example.languagemap.data.learnedItemsList
import com.example.languagemap.data.sharedPref
import com.example.languagemap.databinding.FragmentHomeBinding
import com.example.languagemap.model.Items
import com.example.languagemap.viewmodel.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var bottomNav: BottomNavigationView
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWordsList = getLearnedItemsFromPreferences().toMutableList()
        learnedItemsList = sendLearndItemsFromPreferences().toMutableSet()
        bottomNav = (activity as MainActivity).findViewById(R.id.bottomNavigationView)
        bottomNav.visibility = View.VISIBLE

        observeData()

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.shuflleItems()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.shuffleItemsForOnce()
            viewModel.getCurrentState()
            viewModel.homeUiState.collect {it->
                binding.wordsRecyclerView.adapter = HomeAdapter(it.items.toMutableSet())
            }
        }

    }

    fun getLearnedItemsFromPreferences(): MutableSet<Items> {
        sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val gson = Gson()
        val jsonSet =
            sharedPref.getStringSet("allwords", emptySet())

        return jsonSet?.map { gson.fromJson(it, Items::class.java) }?.toMutableSet()
            ?: mutableSetOf()
    }

    fun sendLearndItemsFromPreferences(): List<Items> {
        sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val learnedItemSet = sharedPref.getStringSet("learnedItems", emptySet()) ?: emptySet()

        val gson = Gson()
        return learnedItemSet.map { gson.fromJson(it, Items::class.java) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}