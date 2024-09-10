package com.example.languagemap.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.languagemap.R
import com.example.languagemap.data.learnedItems
import com.example.languagemap.data.sharedPref
import com.example.languagemap.databinding.RowItemBinding
import com.example.languagemap.model.Items
import com.google.gson.Gson

class HomeAdapter(
    var wordList: List<Items>,
    var onItemClicked : (Items) -> Unit
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {


    inner class HomeViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Items) {
            with(binding) {
                recyclerViewText.text = items.word
                recyclerViewTranslatedText.text = items.translated
            }
            binding.root.setOnClickListener {
                onItemClicked(items)
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
        holder.bind(wordList.elementAt(position))
        sharedPref = holder.itemView.context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val learnedItems = wordList.map{gson.toJson(it)}.toMutableSet()
        holder.binding.recyclerViewCard.setOnClickListener {
            sharedPref.edit().putStringSet("learnedWords", learnedItems).apply()
            findNavController(holder.itemView).navigate(R.id.action_homeFragment_to_itemClickedFragment)
        }
    }

}