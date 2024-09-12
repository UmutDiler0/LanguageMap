package com.example.languagemap.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.languagemap.R
import com.example.languagemap.data.allWords
import com.example.languagemap.data.initWordsList
import com.example.languagemap.data.learnedItemsList
import com.example.languagemap.data.sharedPref
import com.example.languagemap.databinding.FragmentItemClickedBinding
import com.example.languagemap.model.Items
import com.example.languagemap.viewmodel.HomeViewModel
import com.example.languagemap.viewmodel.ItemClickedViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson

class ItemClickedFragment : Fragment() {

    private var _binding: FragmentItemClickedBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ItemClickedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemClickedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ItemClickedViewModel::class.java)
        sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val itemId = ItemClickedFragmentArgs.fromBundle(requireArguments()).items

        with(binding){
            enText.text = itemId.enSentence
            deuText.text = itemId.deuSentence
            trText.text = itemId.trSentence
            itemDetailImage.setImageResource(itemId.itemImage)
        }


        binding.learnedButton.setOnClickListener {
            removeItemFromPreferences(itemId)
            initWordsList.remove(itemId)
            saveLearnedItemsToPreferences(learnedItemsList)
            viewModel.getCurrentState()
            findNavController().navigate(R.id.action_itemClickedFragment_to_homeFragment)

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