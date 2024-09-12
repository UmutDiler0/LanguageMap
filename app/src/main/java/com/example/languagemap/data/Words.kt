package com.example.languagemap.data


import android.content.SharedPreferences
import com.example.languagemap.R
import com.example.languagemap.model.Items

lateinit var sharedPref: SharedPreferences
var learnedItemsList: MutableSet<Items> = mutableSetOf()
var initWordsList: MutableSet<Items> = mutableSetOf()

val allWords = mutableSetOf(

    Items("Apple", "Elma", "Apfel", R.drawable.apple),
    Items("Banana", "Muz", "Banane", R.drawable.banana),
    Items("Cherry", "Kiraz", "Kirsche", R.drawable.cherries),
    Items("Date", "Tarih", "Dattel", R.drawable.date),
    Items("Elderberry", "Kara Mürver", "Holunder",R.drawable.berry),
    Items("Fig", "İncir", "Feige",R.drawable.figs),
    Items("Grape", "Üzüm", "Traube",R.drawable.grape),
    Items("Honeydew", "Kavun", "Honigmelone",R.drawable.melon),
    Items("Kiwi", "Kivi", "Kiwi",R.drawable.kiwi),
    Items("Lemon", "Limon", "Zitrone",R.drawable.lemon),
    Items("Mango", "Mango", "Mango",R.drawable.mango),
    Items("Nectarine", "Şeftali", "Nektarine",R.drawable.nectarine),
    Items("Orange", "Portakal", "Orange",R.drawable.orange),
    Items("Papaya", "Papaya", "Papaya",R.drawable.papaya),
    Items("Quince", "Ayva", "Quitte",R.drawable.quince),
    Items("Raspberry", "Ahududu", "Himbeere",R.drawable.raspberry),
    Items("Strawberry", "Çilek", "Erdbeere",R.drawable.strawberry),
    Items("Tangerine", "Mandalina", "Mandarine",R.drawable.tangerine),
    Items("Watermelon", "Karpuz", "Wassermelone",R.drawable.watermelon),
    Items("Yellow", "Sarı", "Gelb",R.drawable.yellowcard),
    Items("Zucchini", "Kabak", "Zucchini",R.drawable.zucchini),
    Items("Avocado", "Avokado", "Avocado",R.drawable.avocado),
    Items("Blackberry", "Böğürtlen", "Brombeere",R.drawable.blackberry),
    Items("Cantaloupe", "Kavun", "Cantaloupe-Melone",R.drawable.cantaloupe),
    Items("Dragonfruit", "Ejder Meyvesi", "Drachenfrucht",R.drawable.fruit),
    Items("Grapefruit", "Greyfurt", "Grapefruit",R.drawable.grapefruit),
    Items("Huckleberry", "Yaban Mersini", "Heidelbeere",R.drawable.huckleberry),
    Items("Jackfruit", "Jak Meyvesi", "Jackfrucht",R.drawable.jackfruit),
    Items("Kumquat", "Kumkuat", "Kumquat",R.drawable.kumquat),
    Items("Lime", "Limon", "Limette",R.drawable.lime),
    Items("Mangosteen", "Mangostan", "Mangostan",R.drawable.mangosteen),
    Items("Olive", "Zeytin", "Olive",R.drawable.olives),
    Items("Pomegranate", "Nar", "Granatapfel",R.drawable.pomegranate),
    Items("Quince", "Ayva", "Quitte",R.drawable.quince),
    Items("Starfruit", "Karambola", "Sternfrucht",R.drawable.starfruit),
    Items("Umbrella", "Şemsiye", "Regenschirm",R.drawable.umbrella),
    Items("Watermelon", "Karpuz", "Wassermelone",R.drawable.watermelon),
    Items("Yacht", "Yat", "Jacht",R.drawable.yacht),
    Items("Zoo", "Hayvanat Bahçesi", "Zoo",R.drawable.zoo),
    Items("Almond", "Badem", "Mandel",R.drawable.almond),
    Items("Cashew", "Kaju", "Cashew",R.drawable.cashew),
    Items("Chestnut", "Kestane", "Kastanie",R.drawable.chestnut),
    Items("Coconut", "Hindistancevizi", "Kokosnuss",R.drawable.coconut),
    Items("Hazelnut", "Fındık", "Haselnuss",R.drawable.hazelnut),
    Items("Memory", "Hafıza", "Erinnerung",R.drawable.memoryloss),
    Items("Mind", "Akıl", "Verstand",R.drawable.brain),
    Items("Mood", "Ruh Hali", "Stimmung",R.drawable.moodswings),
    Items("Nervous", "Sinirli", "Nervös",R.drawable.anxiety),
    Items("Optimistic", "İyimser", "Optimistisch",R.drawable.optimistic),
    Items("Pessimistic", "Karamsar", "Pessimistisch",R.drawable.pessimistic),
    Items("Personality", "Kişilik", "Persönlichkeit",R.drawable.personality),
    Items("Paper", "Kağıt", "Papier",R.drawable.contract),
    Items("Pen", "Kalem", "Stift",R.drawable.pen),
    Items("Rice", "Pirinç", "Reis",R.drawable.rice),
    Items("Salt", "Tuz", "Salz",R.drawable.saltshaker),
    Items("Sugar", "Şeker", "Zucker",R.drawable.sugarcube),
    Items("Tea", "Çay", "Tee",R.drawable.tea),
    Items("Water", "Su", "Wasser",R.drawable.water),


)