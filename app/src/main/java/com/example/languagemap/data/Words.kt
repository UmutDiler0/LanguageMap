package com.example.languagemap.data

import android.content.Context
import android.content.SharedPreferences
import com.example.languagemap.model.Items
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

lateinit var sharedPref: SharedPreferences
var learnedItemsList: MutableSet<Items> = mutableSetOf()
var initWordsList: MutableSet<Items> = mutableSetOf()

val allWords = mutableSetOf(

    Items("apple", "elma"),
    Items("banana", "muz"),
    Items("cherry", "kiraz"),
    Items("date", "tarih"),
    Items("elderberry", "kara mürver"),
    Items("fig", "incir"),
    Items("grape", "üzüm"),
    Items("honeydew", "kavun"),
    Items("kiwi", "kivi"),
    Items("lemon", "limon"),
    Items("mango", "mango"),
    Items("nectarine", "şeftali"),
    Items("orange", "portakal"),
    Items("papaya", "papaya"),
    Items("quince", "ayva"),
    Items("raspberry", "ahududu"),
    Items("strawberry", "çilek"),
    Items("tangerine", "mandalina"),
    Items("watermelon", "karpuz"),
    Items("yellow", "sarı"),
    Items("zucchini", "kabak"),
    Items("avocado", "avokado"),
    Items("blackberry", "böğürtlen"),
    Items("cantaloupe", "kavun"),
    Items("dragonfruit", "ejder meyvesi"),
    Items("grapefruit", "greyfurt"),
    Items("huckleberry", "yaban mersini"),
    Items("jackfruit", "jak meyvesi"),
    Items("kumquat", "kumkuat"),
    Items("lime", "limon"),
    Items("mangosteen", "mangostan"),
    Items("olive", "zeytin"),
    Items("pomegranate", "nar"),
    Items("quince", "ayva"),
    Items("starfruit", "karambola"),
    Items("umbrella", "şemsiye"),
    Items("watermelon", "karpuz"),
    Items("yacht", "yat"),
    Items("zoo", "Hayvanat Bahçesi"),
    Items("almond", "badem"),
    Items("cashew", "kaju"),
    Items("chestnut", "kestane"),
    Items("coconut", "hindistancevizi"),
    Items("hazelnut", "fındık"),
    Items("memory", "hafıza"),
    Items("mind", "akıl"),
    Items("mood", "ruh hali"),
    Items("nervous", "sinirli"),
    Items("optimistic", "iyimser"),
    Items("pessimistic", "karamsar"),
    Items("personality", "kişilik"),
    Items("paper", "kağıt"),
    Items("pen", "kalem"),
    Items("rice", "pirinç"),
    Items("salt", "tuz"),
    Items("sugar", "şeker"),
    Items("tea", "çay"),
    Items("water", "su"),

)