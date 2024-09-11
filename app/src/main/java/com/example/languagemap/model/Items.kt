package com.example.languagemap.model

import android.os.Parcelable
import java.io.Serializable


data class Items(
    val word: String,
    val translated: String,
): Serializable