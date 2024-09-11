package com.example.languagemap.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.languagemap.R
import com.example.languagemap.databinding.RowItemBinding
import com.example.languagemap.model.Items
import com.google.gson.Gson

class LearnedAdapter(
    var learnedList: MutableSet<Items>,
    var onItemClicked: (Items) -> Unit
) :
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
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LearnedViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return learnedList.size
    }

    override fun onBindViewHolder(holder: LearnedViewHolder, position: Int) {
        holder.bind(learnedList.elementAt(position))
        holder.binding.recyclerViewCard.setOnClickListener {
            onItemClicked(learnedList.elementAt(position))
        }
    }
}