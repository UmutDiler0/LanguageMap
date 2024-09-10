package com.example.languagemap.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.languagemap.R
import com.example.languagemap.data.learnedItems
import com.example.languagemap.data.sharedPref
import com.example.languagemap.databinding.RowItemBinding
import com.example.languagemap.model.Items
import com.google.gson.Gson

class LearnedAdapter(var learnedList: MutableSet<Items>) :
    RecyclerView.Adapter<LearnedAdapter.LearnedViewHolder>() {

    class LearnedViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Items) {
            with(binding) {
                recyclerViewText.text = items.word
                recyclerViewTranslatedText.text = items.translated
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedViewHolder {
        val learnedWord = sharedPref.getStringSet("word", mutableSetOf())
        val learnedTranslated = sharedPref.getStringSet("translated", mutableSetOf())
        learnedList.add(Items(learnedWord.toString(), learnedTranslated.toString()))
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LearnedViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return learnedList.size
    }

    override fun onBindViewHolder(holder: LearnedViewHolder, position: Int) {
        holder.bind(learnedList.elementAt(position))
        sharedPref = holder.itemView.context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        holder.binding.recyclerViewCard.setOnClickListener {
            findNavController(it).navigate(R.id.action_learnedFragment_to_learnedItemFragment)
        }
    }
    fun loadLearnedItems() {
        val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val learnedItemSet = sharedPreferences.getStringSet("learnedItems", null)

        if (!learnedItemSet.isNullOrEmpty()) {
            val gson = Gson()
            learnedItems = learnedItemSet.map { gson.fromJson(it, Items::class.java) }
            notifyDataSetChanged()  // Veriler değiştiğinde RecyclerView'ı güncelliyoruz
        }
    }

}