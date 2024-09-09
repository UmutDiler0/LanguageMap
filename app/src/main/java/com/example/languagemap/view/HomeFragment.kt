package com.example.languagemap.view

import android.os.Bundle
import android.provider.UserDictionary.Words
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.languagemap.R
import com.example.languagemap.adapter.HomeAdapter
import com.example.languagemap.data.allWords
import com.example.languagemap.databinding.FragmentHomeBinding
import com.example.languagemap.model.Items
import com.example.languagemap.viewmodel.HomeViewModel
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel
    private var shuffledList: List<Items> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        observeData()

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.shuflleItems()
            observeData()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    fun observeData(){
        viewModel.shuffleItemsForOnce()
        lifecycleScope.launch {
            viewModel.itemsState.collect {
                binding.countyRecyclerView.adapter = HomeAdapter(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}