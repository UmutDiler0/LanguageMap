package com.example.languagemap.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.languagemap.adapter.LearnedAdapter
import com.example.languagemap.data.sharedPref
import com.example.languagemap.databinding.FragmentLearnedBinding
import com.example.languagemap.model.Items
import com.example.languagemap.viewmodel.LearnedViewModel
import kotlinx.coroutines.launch

class LearnedFragment : Fragment() {

    private var _binding : FragmentLearnedBinding? = null
    private val binding get() = _binding!!
    private lateinit var mutableList: MutableSet<Items>
    private lateinit var viewModel: LearnedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLearnedBinding.inflate(inflater, container, false)
        mutableList = mutableSetOf()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LearnedViewModel::class.java)
        mutableList.add(Items(sharedPref.getStringSet(
            "word", mutableSetOf()).toString(), sharedPref.getStringSet("translated", mutableSetOf()).toString()))
        lifecycleScope.launch {
            viewModel.addLearned(mutableList)
            binding.learnedRecyclerView.adapter = LearnedAdapter(mutableList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}