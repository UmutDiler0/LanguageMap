package com.example.languagemap.model

data class GameUiState(
    val currentWord: String = "",
    var currentTranslationTR: String = "",
    var currentTranslationDEU: String = "",
    var isCorrect: Boolean = true,
    var isGameOver: Boolean? = null
)