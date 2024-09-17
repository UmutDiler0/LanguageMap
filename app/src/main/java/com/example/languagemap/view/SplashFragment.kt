package com.example.languagemap.view

import android.content.Context
import android.os.Bundle
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

        val navController = navHostFragment.navController
        val navOpttion = NavOptions.Builder().setPopUpTo(R.id.splashFragment, true).build()

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



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}