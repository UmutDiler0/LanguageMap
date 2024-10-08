package com.example.languagemap.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.languagemap.R
import com.example.languagemap.data.initWordsList
import com.example.languagemap.data.learnedItemsList
import com.example.languagemap.data.sharedPref
import com.example.languagemap.databinding.FragmentItemClickedBinding
import com.example.languagemap.model.Items
import com.example.languagemap.viewmodel.HomeViewModel
import com.example.languagemap.viewmodel.ItemClickedViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson
import kotlinx.coroutines.launch

class ItemClickedFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentItemClickedBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemClickedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val itemId = ItemClickedFragmentArgs.fromBundle(requireArguments()).items

        with(binding){
            enText.text = itemId.description_en
            deuText.text = itemId.description_de
            trText.text = itemId.description_tr
            itemDetailImage.setImageResource(itemId.image)
        }

        observeData()

        binding.learnedButton.setOnClickListener {
            removeItemFromPreferences(itemId)
            learnedItemsList.add(itemId)
            initWordsList.remove(itemId)
            viewModel.removeItemFromList(itemId)
            saveLearnedItemsToPreferences(learnedItemsList)
            findNavController().navigate(R.id.action_itemClickedFragment_to_homeFragment)

        }
    }

    private fun observeData(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.homeUiState.collect {it->
                initWordsList = it.items.toMutableList()
            }
        }
    }

    private fun removeItemFromPreferences(item: Items) {
        sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val gson = Gson()

        val savedItems = sharedPref.getStringSet("allwords", emptySet())?.toMutableSet() ?: mutableSetOf()

        val jsonItem = gson.toJson(item)

        savedItems.remove(jsonItem)

        editor.putStringSet("allwords", savedItems)
        editor.apply()
    }

    private fun saveLearnedItemsToPreferences(learnedItem: MutableSet<Items>) {
        val editor = sharedPref.edit()
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