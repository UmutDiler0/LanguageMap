package com.example.languagemap.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.languagemap.R
import com.example.languagemap.data.API_KEY
import com.example.languagemap.databinding.FragmentGeminiBinding
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking


class GeminiFragment : Fragment() {

    private var _binding: FragmentGeminiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGeminiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            val prompt = binding.askGemini.text.toString()

            val generetiveModel = GenerativeModel(
                modelName = "gemini-pro",
                apiKey = API_KEY
            )
            runBlocking {
                val response = generetiveModel.generateContent(prompt)
                binding.tVResult.text = response.text
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}