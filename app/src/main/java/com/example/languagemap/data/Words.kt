package com.example.languagemap.data


import android.content.SharedPreferences
import com.example.languagemap.R
import com.example.languagemap.model.Items

lateinit var sharedPref: SharedPreferences
var learnedItemsList: MutableSet<Items> = mutableSetOf()
var initWordsList: MutableSet<Items> = mutableSetOf()
const val API_KEY = "AIzaSyCS5iMCL6yNReRJMavfBt5-GhpGkPAdr3c"


val allWords = mutableSetOf(

    Items("Apple", "Elma", "Apfel", R.drawable.apple, "Elma severim.", "Ich mag Äpfel.", "I like apples."),
    Items("Banana", "Muz", "Banane", R.drawable.banana, "Muz yemeyi severim.", "Ich esse gerne Bananen.", "I like eating bananas."),
    Items("Cherry", "Kiraz", "Kirsche", R.drawable.cherries, "Kiraz tatlıdır.", "Kirschen sind süß.", "Cherries are sweet."),
    Items("Date", "Tarih", "Dattel", R.drawable.date, "Tarihler önemlidir.", "Daten sind wichtig.", "Dates are important."),
    Items("Elderberry", "Kara Mürver", "Holunder", R.drawable.berry, "Kara mürver şifalıdır.", "Holunderbeeren sind heilend.", "Elderberries are healing."),
    Items("Fig", "İncir", "Feige", R.drawable.figs, "İncir tatlıdır.", "Feigen sind süß.", "Figs are sweet."),
    Items("Grape", "Üzüm", "Traube", R.drawable.grape, "Üzüm sağlıklıdır.", "Trauben sind gesund.", "Grapes are healthy."),
    Items("Honeydew", "Kavun", "Honigmelone", R.drawable.melon, "Kavun sulu bir meyvedir.", "Honigmelonen sind saftig.", "Honeydew is a juicy fruit."),
    Items("Kiwi", "Kivi", "Kiwi", R.drawable.kiwi, "Kivi ekşi bir meyvedir.", "Kiwi ist eine saure Frucht.", "Kiwi is a sour fruit."),
    Items("Lemon", "Limon", "Zitrone", R.drawable.lemon, "Limon ekşidir.", "Zitronen sind sauer.", "Lemons are sour."),
    Items("Mango", "Mango", "Mango", R.drawable.mango, "Mango tropikal bir meyvedir.", "Mango ist eine tropische Frucht.", "Mango is a tropical fruit."),
    Items("Nectarine", "Şeftali", "Nektarine", R.drawable.nectarine, "Şeftaliyi çok severim.", "Ich liebe Nektarinen.", "I love nectarines."),
    Items("Orange", "Portakal", "Orange", R.drawable.orange, "Portakal suyu sağlıklıdır.", "Orangensaft ist gesund.", "Orange juice is healthy."),
    Items("Papaya", "Papaya", "Papaya", R.drawable.papaya, "Papaya nadir bulunan bir meyvedir.", "Papaya ist eine seltene Frucht.", "Papaya is a rare fruit."),
    Items("Quince", "Ayva", "Quitte", R.drawable.quince, "Ayva çok serttir.", "Quitten sind sehr hart.", "Quince is very hard."),
    Items("Raspberry", "Ahududu", "Himbeere", R.drawable.raspberry, "Ahududu tatlıdır.", "Himbeeren sind süß.", "Raspberries are sweet."),
    Items("Strawberry", "Çilek", "Erdbeere", R.drawable.strawberry, "Çilek kırmızı renktedir.", "Erdbeeren sind rot.", "Strawberries are red."),
    Items("Tangerine", "Mandalina", "Mandarine", R.drawable.tangerine, "Mandalina portakaldan küçüktür.", "Mandarinen sind kleiner als Orangen.", "Tangerines are smaller than oranges."),
    Items("Watermelon", "Karpuz", "Wassermelone", R.drawable.watermelon, "Karpuz serinletir.", "Wassermelonen sind erfrischend.", "Watermelon is refreshing."),
    Items("Yellow", "Sarı", "Gelb", R.drawable.yellowcard, "Sarı parlak bir renktir.", "Gelb ist eine leuchtende Farbe.", "Yellow is a bright color."),
    Items("Zucchini", "Kabak", "Zucchini", R.drawable.zucchini, "Kabak sağlıklıdır.", "Zucchini sind gesund.", "Zucchini is healthy."),
    Items("Avocado", "Avokado", "Avocado", R.drawable.avocado, "Avokado lezzetlidir.", "Avocados sind lecker.", "Avocado is delicious."),
    Items("Blackberry", "Böğürtlen", "Brombeere", R.drawable.blackberry, "Böğürtlen ekşi olabilir.", "Brombeeren können sauer sein.", "Blackberries can be sour."),
    Items("Cantaloupe", "Kavun", "Cantaloupe-Melone", R.drawable.cantaloupe, "Kavun tatlıdır.", "Cantaloupe-Melonen sind süß.", "Cantaloupe is sweet."),
    Items("Dragonfruit", "Ejder Meyvesi", "Drachenfrucht", R.drawable.fruit, "Ejder meyvesi egzotiktir.", "Drachenfrüchte sind exotisch.", "Dragonfruit is exotic."),
    Items("Grapefruit", "Greyfurt", "Grapefruit", R.drawable.grapefruit, "Greyfurt acıdır.", "Grapefruits sind bitter.", "Grapefruit is bitter."),
    Items("Huckleberry", "Yaban Mersini", "Heidelbeere", R.drawable.huckleberry, "Yaban mersini mor renktedir.", "Heidelbeeren sind lila.", "Huckleberries are purple."),
    Items("Jackfruit", "Jak Meyvesi", "Jackfrucht", R.drawable.jackfruit, "Jak meyvesi büyüktür.", "Jackfrüchte sind groß.", "Jackfruit is large."),
    Items("Kumquat", "Kumkuat", "Kumquat", R.drawable.kumquat, "Kumkuat küçüktür.", "Kumquats sind klein.", "Kumquats are small."),
    Items("Lime", "Limon", "Limette", R.drawable.lime, "Limon ekşidir.", "Limetten sind sauer.", "Limes are sour."),
    Items("Mangosteen", "Mangostan", "Mangostan", R.drawable.mangosteen, "Mangostan tatlıdır.", "Mangostane sind süß.", "Mangosteen is sweet."),
    Items("Olive", "Zeytin", "Olive", R.drawable.olives, "Zeytin tuzludur.", "Oliven sind salzig.", "Olives are salty."),
    Items("Pomegranate", "Nar", "Granatapfel", R.drawable.pomegranate, "Nar lezzetlidir.", "Granatäpfel sind lecker.", "Pomegranate is delicious."),
    Items("Starfruit", "Karambola", "Sternfrucht", R.drawable.starfruit, "Karambola yıldız şeklindedir.", "Sternfrüchte sind sternförmig.", "Starfruit is star-shaped."),
    Items("Umbrella", "Şemsiye", "Regenschirm", R.drawable.umbrella, "Şemsiye yağmurda kullanılır.", "Regenschirme werden bei Regen benutzt.", "Umbrellas are used in the rain."),
    Items("Yacht", "Yat", "Jacht", R.drawable.yacht, "Yatlar denizde kullanılır.", "Jachten werden auf dem Meer verwendet.", "Yachts are used on the sea."),
    Items("Zoo", "Hayvanat Bahçesi", "Zoo", R.drawable.zoo, "Hayvanat bahçesinde birçok hayvan vardır.", "Im Zoo gibt es viele Tiere.", "There are many animals in the zoo."),
    Items("Almond", "Badem", "Mandel", R.drawable.almond, "Badem faydalıdır.", "Mandeln sind gesund.", "Almonds are healthy."),
    Items("Cashew", "Kaju", "Cashew", R.drawable.cashew, "Kaju fıstığı lezzetlidir.", "Cashews sind lecker.", "Cashews are delicious."),
    Items("Chestnut", "Kestane", "Kastanie", R.drawable.chestnut, "Kestane kışın yenir.", "Kastanien werden im Winter gegessen.", "Chestnuts are eaten in winter."),
    Items("Coconut", "Hindistancevizi", "Kokosnuss", R.drawable.coconut, "Hindistancevizi beyazdır.", "Kokosnüsse sind weiß.", "Coconuts are white."),
    Items("Hazelnut", "Fındık", "Haselnuss", R.drawable.hazelnut, "Fındık kahverengidir.", "Haselnüsse sind braun.", "Hazelnuts are brown."),
    Items("Memory", "Hafıza", "Erinnerung", R.drawable.memoryloss, "Hafıza önemlidir.", "Erinnerungen sind wichtig.", "Memory is important."),
    Items("Mind", "Akıl", "Verstand", R.drawable.brain, "Akıl güçlüdür.", "Der Verstand ist stark.", "The mind is strong."),
    Items("Mood", "Ruh Hali", "Stimmung", R.drawable.moodswings, "Ruh hali değişebilir.", "Die Stimmung kann sich ändern.", "Mood can change."),
    Items("Nervous", "Sinirli", "Nervös", R.drawable.anxiety, "Sinirli olduğunda nefes al.", "Atme, wenn du nervös bist.", "Breathe when you are nervous."),
    Items("Optimistic", "İyimser", "Optimistisch", R.drawable.optimistic, "İyimser insanlar mutludur.", "Optimistische Menschen sind glücklich.", "Optimistic people are happy."),
    Items("Pessimistic", "Karamsar", "Pessimistisch", R.drawable.pessimistic, "Karamsar olmak kötüdür.", "Pessimistisch zu sein ist schlecht.", "Being pessimistic is bad."),
    Items("Personality", "Kişilik", "Persönlichkeit", R.drawable.personality, "Kişilik seni tanımlar.", "Die Persönlichkeit definiert dich.", "Personality defines you."),
    Items("Paper", "Kağıt", "Papier", R.drawable.contract, "Kağıt yazmak içindir.", "Papier ist zum Schreiben.", "Paper is for writing."),
    Items("Pen", "Kalem", "Stift", R.drawable.pen, "Kalem yazmak içindir.", "Ein Stift ist zum Schreiben.", "A pen is for writing."),
    Items("Rice", "Pirinç", "Reis", R.drawable.rice, "Pirinç dünyanın birçok yerinde yenir.", "Reis wird weltweit gegessen.", "Rice is eaten in many places worldwide."),
    Items("Salt", "Tuz", "Salz", R.drawable.saltshaker, "Tuz yemeklere tat verir.", "Salz gibt den Speisen Geschmack.", "Salt gives flavor to food."),
    Items("Sugar", "Şeker", "Zucker", R.drawable.sugarcube, "Şeker tatlıdır.", "Zucker ist süß.", "Sugar is sweet."),
    Items("Tea", "Çay", "Tee", R.drawable.tea, "Çay içmeyi severim.", "Ich trinke gerne Tee.", "I like drinking tea."),
    Items("Water", "Su", "Wasser", R.drawable.water, "Su yaşam kaynağıdır.", "Wasser ist die Quelle des Lebens.", "Water is the source of life.")



)