package com.example.languagemap.view


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.languagemap.adapter.LearnedAdapter
import com.example.languagemap.data.learnedItems
import com.example.languagemap.data.sharedPref
import com.example.languagemap.databinding.FragmentLearnedBinding
import com.example.languagemap.model.Items
import com.google.gson.Gson

class LearnedFragment : Fragment() {

    private var _binding : FragmentLearnedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLearnedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val learnedItems = getLearnedItemsFromPreferences().toMutableSet()
        binding.learnedRecyclerView.adapter = LearnedAdapter(learnedItems)

    }
    fun getLearnedItemsFromPreferences(): List<Items> {
        val sharedPreferences =
            requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val learnedItemSet = sharedPreferences.getStringSet("learnedWords", null)

        return if (!learnedItemSet.isNullOrEmpty()) {
            val gson = Gson()
            learnedItemSet.map { gson.fromJson(it, Items::class.java) }
        } else {
            emptyList()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}