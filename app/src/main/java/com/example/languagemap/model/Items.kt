package com.example.languagemap.model

import java.io.Serializable

data class Items(
    val word: String,
    val translated: String,
    val translated2: String,
    val itemImage: Int,
    val trSentence: String? = null,
    val deuSentence: String? = null,
    val enSentence: String? = null
): Serializable