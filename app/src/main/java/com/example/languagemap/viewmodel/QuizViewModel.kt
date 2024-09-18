package com.example.languagemap.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.languagemap.data.learnedItemsList
import com.example.languagemap.model.GameUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class QuizViewModel : ViewModel() {

    private var _currentWord = MutableStateFlow(GameUiState())
    val currentWord get() = _currentWord
    var usedWordList: MutableList<String> = mutableListOf()

    fun getNewWord() {
        if(_currentWord.value.isCorrect){
            if (learnedItemsList.isEmpty()) {
                _currentWord.value = GameUiState(
                    currentWord = "No words to learn"
                )
            } else {
                if (isUsedListFull()) {
                    _currentWord.value = GameUiState(
                        currentWord = "You have learned all the words"
                    )
                    return
                } else {
                    learnedItemsList.random().let { word ->
                        if (usedWordList.contains(word.word)) {
                            getNewWord()
                            return
                        }else{
                            _currentWord.update {
                                it.copy(
                                    currentWord = word.word,
                                    currentTranslationTR = word.translated,
                                    currentTranslationDEU = word.translated2
                                )
                            }

                        }
                    }
                }
            }
        }else{
            _currentWord.update {
                it.copy(
                    currentWord = _currentWord.value.currentWord,
                    currentTranslationTR = _currentWord.value.currentTranslationTR,
                    currentTranslationDEU = _currentWord.value.currentTranslationDEU
                )
            }
        }

    }

    fun isUsedListFull(): Boolean {
        if (usedWordList.size == learnedItemsList.size) {
            return true
        } else {
            return false

        }
    }

    fun checkUserGuess(userGuess: String): Boolean {
        if (
            userGuess.equals(_currentWord.value.currentTranslationTR, ignoreCase = true)
            || userGuess.equals(_currentWord.value.currentTranslationDEU, ignoreCase = true)
        ) {
            usedWordList.add(_currentWord.value.currentWord)
            _currentWord.update{
                it.copy(
                    isCorrect = true
                )
            }
            getNewWord()
            return _currentWord.value.isCorrect
        } else {
            _currentWord.update{
                it.copy(
                    currentWord = _currentWord.value.currentWord,
                    isCorrect = false
                )
            }
            return _currentWord.value.isCorrect
        }
    }

}
