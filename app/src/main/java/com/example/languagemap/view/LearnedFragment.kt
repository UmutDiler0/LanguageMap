package com.example.languagemap.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.languagemap.adapter.LearnedAdapter
import com.example.languagemap.data.learnedItemsList
import com.example.languagemap.databinding.FragmentLearnedBinding
import com.example.languagemap.viewmodel.LearnViewModel
import kotlinx.coroutines.launch

class LearnedFragment : Fragment() {

    private var _binding : FragmentLearnedBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LearnViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLearnedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            setViewGone()
            learnedRecyclerView.adapter = LearnedAdapter(learnedItemsList)
        }
        observeData()
    }

    fun observeData(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.checkLearnedList()
            viewModel.learnState.collect {
                if (it.isLearnedListEmpty) {
                    setViewVisible()
                } else {
                    setViewGone()
                }
            }
        }
    }

    private fun setViewVisible(){
        binding.learnedStateImage.visibility = View.VISIBLE
        binding.learnedStateText.visibility = View.VISIBLE
    }

    private fun setViewGone(){
        binding.learnedStateImage.visibility = View.GONE
        binding.learnedStateText.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}