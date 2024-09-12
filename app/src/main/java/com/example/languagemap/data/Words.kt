package com.example.languagemap.data


import android.content.SharedPreferences
import com.example.languagemap.model.Items

lateinit var sharedPref: SharedPreferences
var learnedItemsList: MutableSet<Items> = mutableSetOf()
var initWordsList: MutableSet<Items> = mutableSetOf()

val allWords = mutableSetOf(

    Items("Apple", "Elma", "Apfel"),
    Items("Banana", "Muz", "Banane"),
    Items("Cherry", "Kiraz", "Kirsche"),
    Items("Date", "Tarih", "Dattel"),
    Items("Elderberry", "Kara Mürver", "Holunder"),
    Items("Fig", "İncir", "Feige"),
    Items("Grape", "Üzüm", "Traube"),
    Items("Honeydew", "Kavun", "Honigmelone"),
    Items("Kiwi", "Kivi", "Kiwi"),
    Items("Lemon", "Limon", "Zitrone"),
    Items("Mango", "Mango", "Mango"),
    Items("Nectarine", "Şeftali", "Nektarine"),
    Items("Orange", "Portakal", "Orange"),
    Items("Papaya", "Papaya", "Papaya"),
    Items("Quince", "Ayva", "Quitte"),
    Items("Raspberry", "Ahududu", "Himbeere"),
    Items("Strawberry", "Çilek", "Erdbeere"),
    Items("Tangerine", "Mandalina", "Mandarine"),
    Items("Watermelon", "Karpuz", "Wassermelone"),
    Items("Yellow", "Sarı", "Gelb"),
    Items("Zucchini", "Kabak", "Zucchini"),
    Items("Avocado", "Avokado", "Avocado"),
    Items("Blackberry", "Böğürtlen", "Brombeere"),
    Items("Cantaloupe", "Kavun", "Cantaloupe-Melone"),
    Items("Dragonfruit", "Ejder Meyvesi", "Drachenfrucht"),
    Items("Grapefruit", "Greyfurt", "Grapefruit"),
    Items("Huckleberry", "Yaban Mersini", "Heidelbeere"),
    Items("Jackfruit", "Jak Meyvesi", "Jackfrucht"),
    Items("Kumquat", "Kumkuat", "Kumquat"),
    Items("Lime", "Limon", "Limette"),
    Items("Mangosteen", "Mangostan", "Mangostan"),
    Items("Olive", "Zeytin", "Olive"),
    Items("Pomegranate", "Nar", "Granatapfel"),
    Items("Quince", "Ayva", "Quitte"),
    Items("Starfruit", "Karambola", "Sternfrucht"),
    Items("Umbrella", "Şemsiye", "Regenschirm"),
    Items("Watermelon", "Karpuz", "Wassermelone"),
    Items("Yacht", "Yat", "Jacht"),
    Items("Zoo", "Hayvanat Bahçesi", "Zoo"),
    Items("Almond", "Badem", "Mandel"),
    Items("Cashew", "Kaju", "Cashew"),
    Items("Chestnut", "Kestane", "Kastanie"),
    Items("Coconut", "Hindistancevizi", "Kokosnuss"),
    Items("Hazelnut", "Fındık", "Haselnuss"),
    Items("Memory", "Hafıza", "Erinnerung"),
    Items("Mind", "Akıl", "Verstand"),
    Items("Mood", "Ruh Hali", "Stimmung"),
    Items("Nervous", "Sinirli", "Nervös"),
    Items("Optimistic", "İyimser", "Optimistisch"),
    Items("Pessimistic", "Karamsar", "Pessimistisch"),
    Items("Personality", "Kişilik", "Persönlichkeit"),
    Items("Paper", "Kağıt", "Papier"),
    Items("Pen", "Kalem", "Stift"),
    Items("Rice", "Pirinç", "Reis"),
    Items("Salt", "Tuz", "Salz"),
    Items("Sugar", "Şeker", "Zucker"),
    Items("Tea", "Çay", "Tee"),
    Items("Water", "Su", "Wasser")

)