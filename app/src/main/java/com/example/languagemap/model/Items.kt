package com.example.languagemap.model

import java.io.Serializable

data class Items(
    val name_en: String = "",
    val name_tr: String = "",
    val name_de: String = "",
    val image: Int,
    val description_tr: String? = null,
    val description_de: String? = null,
    val description_en: String? = null
): Serializable