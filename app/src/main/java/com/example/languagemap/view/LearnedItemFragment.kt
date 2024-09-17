package com.example.languagemap.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.languagemap.R
import com.example.languagemap.adapter.LearnedAdapter
import com.example.languagemap.data.initWordsList
import com.example.languagemap.data.learnedItemsList
import com.example.languagemap.databinding.FragmentLearnedItemBinding
import com.example.languagemap.model.Items
import com.example.languagemap.viewmodel.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson

class LearnedItemFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentLearnedItemBinding? = null
    private val binding get() = _binding!!
    lateinit var sharedPref: SharedPreferences
    private val viewModel : HomeViewModel by activityViewModels()

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
        viewModel.addItemToList(itemId)

        with(binding){
            enLearnedText.text = itemId.enSentence
            deuText.text = itemId.deuSentence
            trLearnedText.text = itemId.trSentence
            learnedDetailImage.setImageResource(itemId.itemImage)
        }

        binding.unlearnedButton.setOnClickListener {
            removeItemFromLearnedItems(itemId)
            findNavController().navigate(R.id.action_learnedItemFragment_to_learnedFragment)
        }
    }

    fun removeItemFromLearnedItems(item: Items) {
        learnedItemsList.remove(item)
        initWordsList.add(item)

        removeItemFromPreferences(item)
        saveLearnedItemsToPreferences(initWordsList.toMutableSet())
    }

    fun saveLearnedItemsToPreferences(learnedItem: MutableSet<Items>) {
        sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = com.example.languagemap.data.sharedPref.edit()

        val gson = Gson()
        val learnedItemSet = learnedItem.map { gson.toJson(it) }.toSet()

        editor.putStringSet("allwords", learnedItemSet)
        editor.apply()

    }

    private fun removeItemFromPreferences(item: Items) {
        com.example.languagemap.data.sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = com.example.languagemap.data.sharedPref.edit()

        val gson = Gson()

        val savedItems = com.example.languagemap.data.sharedPref.getStringSet("learnedItems", emptySet())?.toMutableSet() ?: mutableSetOf()

        val jsonItem = gson.toJson(item)

        savedItems.remove(jsonItem)

        editor.putStringSet("learnedItems", savedItems)
        editor.apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}