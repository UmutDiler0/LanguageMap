package com.example.languagemap.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Items(
    val word: String,
    val translated: String,
)