package com.example.languagemap.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.languagemap.MainActivity
import com.example.languagemap.R
import com.example.languagemap.data.allWords
import com.example.languagemap.data.sharedPref
import com.example.languagemap.databinding.FragmentSplashBinding
import com.example.languagemap.model.Items
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class SplashFragment : Fragment() {

    private lateinit var navHostFragment: NavHostFragment
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        bottomNav = (activity as MainActivity).findViewById(R.id.bottomNavigationView)
        bottomNav.visibility = View.GONE

        val navOpttion = NavOptions.Builder().setPopUpTo(R.id.splashFragment, true).build()

//        val parsedItems: MutableSet<Items> = readItemsFromAssets(requireContext())
//        allWords.addAll(parsedItems)

        if (!isPreferencesNotEmpty()) {
            saveLearnedItemsToPreferences(allWords)
        }
        android.os.Handler(requireContext().mainLooper).postDelayed({
            navHostFragment.navController.navigate(R.id.action_splashFragment_to_homeFragment,null,navOpttion)
        }, 3000)
    }

    fun isPreferencesNotEmpty(): Boolean {
        sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val savedItems = sharedPref.getStringSet("allwords", null)

        return !savedItems.isNullOrEmpty()
    }

    fun saveLearnedItemsToPreferences(learnedItem: MutableSet<Items>) {
        sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val gson = Gson()
        val allWordSet = learnedItem.map { gson.toJson(it) }.toSet()

        editor.putStringSet("allwords", allWordSet)
        editor.apply()

    }

//    fun readItemsFromAssets(context: Context): MutableSet<Items> {
//        return try {
//            val jsonFileString = context.assets.open("items_list.json").bufferedReader().use { it.readText() }
//            val listItemType = object : TypeToken<List<Items>>() {}.type
//            Gson().fromJson<List<Items>>(jsonFileString, listItemType).toMutableSet()
//        } catch (e: Exception) {
//            mutableSetOf()
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}