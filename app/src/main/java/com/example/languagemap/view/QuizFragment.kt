package com.example.languagemap.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.languagemap.R
import com.example.languagemap.databinding.FragmentQuizBinding
import com.example.languagemap.viewmodel.QuizViewModel
import kotlinx.coroutines.launch


class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: QuizViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        binding.correctAnswer.visibility = View.GONE
        binding.falseAnswer.visibility = View.GONE

        binding.submitBtn.setOnClickListener {
            if(viewModel.checkUserGuess(binding.answerEditText.text.toString())){
                binding.correctAnswer.visibility = View.VISIBLE
                binding.falseAnswer.visibility = View.GONE
                observeData()
            }else{
                binding.falseAnswer.visibility = View.VISIBLE
                binding.correctAnswer.visibility = View.GONE
                observeData()
            }
        }

        if(viewModel.isUsedListFull()){
            binding.submitBtn.isEnabled = false
            binding.answerEditText.isEnabled = false
        }else{
            binding.submitBtn.isEnabled = true
            binding.answerEditText.isEnabled = true
        }
        observeData()
    }


    private fun observeData(){
        lifecycleScope.launch{
            viewModel.getNewWord()
            viewModel.currentWord.collect {
                binding.wordTextView.text = it.currentWord

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}