package com.example.languagemap.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.languagemap.R
import com.example.languagemap.databinding.FragmentItemClickedBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ItemClickedFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentItemClickedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemClickedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}