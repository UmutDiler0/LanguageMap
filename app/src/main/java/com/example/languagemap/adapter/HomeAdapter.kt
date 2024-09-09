package com.example.languagemap.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.languagemap.R
import com.example.languagemap.data.sharedPref
import com.example.languagemap.databinding.RowItemBinding
import com.example.languagemap.model.Items

class HomeAdapter(var wordList: List<Items>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Items) {
            with(binding) {
                recyclerViewText.text = items.word
                recyclerViewTranslatedText.text = items.translated
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        sharedPref = holder.itemView.context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        holder.bind(wordList.elementAt(position))
        holder.binding.recyclerViewCard.setOnClickListener {
            sharedPref.edit().putStringSet("word", setOf(wordList[position].word)).apply()
            sharedPref.edit().putStringSet("translated", setOf(wordList[position].translated)).apply()
            findNavController(it).navigate(R.id.action_homeFragment_to_itemClickedFragment)
        }
    }
}