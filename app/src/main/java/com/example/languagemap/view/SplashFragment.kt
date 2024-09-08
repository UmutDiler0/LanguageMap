package com.example.languagemap.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.languagemap.R

class SplashFragment : Fragment() {

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        android.os.Handler(requireContext().mainLooper).postDelayed({
            navHostFragment.navController.navigate(R.id.action_splashFragment_to_homeFragment2)
        }, 1000)
    }

}