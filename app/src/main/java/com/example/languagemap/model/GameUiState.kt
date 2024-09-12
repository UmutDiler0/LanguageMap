package com.example.languagemap.model

data class GameUiState(
    val currentWord: String = "",
    var currentTranslation: String = "",
    var isCorrect: Boolean? = null,
    var isGameOver: Boolean? = null
)