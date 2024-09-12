package com.example.languagemap.viewmodel

import androidx.lifecycle.ViewModel
import com.example.languagemap.data.learnedItemsList
import com.example.languagemap.model.GameUiState
import kotlinx.coroutines.flow.MutableStateFlow

class QuizViewModel : ViewModel() {

    private var _currentWord = MutableStateFlow(GameUiState())
    val currentWord get() = _currentWord
    var quizList: MutableList<String> = mutableListOf()

    fun getNewWord() {
        if (learnedItemsList.isEmpty()) {
            _currentWord.value = GameUiState(
                currentWord = "No words to learn"
            )
        } else {
            if(isQuizListFull()){
                _currentWord.value = GameUiState(
                    currentWord = "You have learned all the words"
                )
                return
            }else{
                if (quizList.contains(learnedItemsList.random().word)) {
                    getNewWord()
                }else{
                    learnedItemsList.random().let {
                        _currentWord.value = GameUiState(
                            currentWord = it.word,
                            currentTranslationTR = it.translated,
                            currentTranslationDEU = it.translated2
                        )
                    }
                }
            }
        }
    }

    private fun isQuizListFull(): Boolean{
        if(quizList.size == learnedItemsList.size){
            return true
        }else{
            return false
        }
    }

    fun checkUserGuess(userGuess: String): Boolean {
        if (
            userGuess.equals(_currentWord.value.currentTranslationTR, ignoreCase = true)
            ) {
            quizList.add(_currentWord.value.currentWord)
            _currentWord.value = _currentWord.value.copy(
                isCorrect = true
            )
            getNewWord()
            return true
        } else {
            _currentWord.value = _currentWord.value.copy(
                isCorrect = false
            )
            return false
        }
    }

}
