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
import androidx.navigation.fragment.findNavController
import com.example.languagemap.R
import com.example.languagemap.adapter.LearnedAdapter
import com.example.languagemap.data.allWords
import com.example.languagemap.data.learnedItemsList
import com.example.languagemap.data.sharedPref
import com.example.languagemap.databinding.FragmentLearnedBinding
import com.example.languagemap.model.Items
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
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
        learnedItemsList = getLearnedItemsFromPreferences().toMutableSet()
       binding.learnedRecyclerView.adapter = LearnedAdapter(learnedItemsList)
    }

    fun getLearnedItemsFromPreferences(): List<Items> {
        sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val learnedItemSet = sharedPref.getStringSet("learnedItems", emptySet()) ?: emptySet()

        val gson = Gson()
        return learnedItemSet.map { gson.fromJson(it, Items::class.java) }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}