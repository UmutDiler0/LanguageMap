package com.example.languagemap.viewmodel

import androidx.lifecycle.ViewModel
import com.example.languagemap.model.GameUiState
import kotlinx.coroutines.flow.MutableStateFlow

class QuizViewModel: ViewModel(){

    private var _currenWord = MutableStateFlow(GameUiState())
    val currentWord get() = _currenWord

    fun getNewWord(){

    }
}