package com.example.languagemap.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.languagemap.adapter.LearnedAdapter
import com.example.languagemap.data.learnedItemsList
import com.example.languagemap.databinding.FragmentLearnedItemBinding
import com.example.languagemap.model.Items
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson

class LearnedItemFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentLearnedItemBinding? = null
    private val binding get() = _binding!!
    lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLearnedItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val itemId = LearnedItemFragmentArgs.fromBundle(requireArguments()).item

        binding.unlearnedItemButton.setOnClickListener {
            removeItemFromLearnedItems(itemId)
            dismiss()
        }

        binding.clearList.setOnClickListener {
            sharedPref.edit().clear().apply()
        }
    }

    fun removeItemFromLearnedItems(item: Items) {
        learnedItemsList.remove(item)
//        sharedPref.edit().clear().apply()
        saveLearnedItemsToPreferences(learnedItemsList)
    }

    fun saveLearnedItemsToPreferences(learnedItem: MutableSet<Items>) {
        sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = com.example.languagemap.data.sharedPref.edit()

        val gson = Gson()
        val learnedItemSet = learnedItem.map { gson.toJson(it) }.toSet()

        editor.putStringSet("learnedItems", learnedItemSet)
        editor.apply()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}