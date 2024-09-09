package com.example.languagemap.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.languagemap.R
import com.example.languagemap.data.sharedPref
import com.example.languagemap.databinding.FragmentLearnedItemBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class LearnedItemFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentLearnedItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLearnedItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.unlearnedItemButton.setOnClickListener {
            sharedPref.edit().remove("word").apply()
            sharedPref.edit().remove("translated").apply()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}