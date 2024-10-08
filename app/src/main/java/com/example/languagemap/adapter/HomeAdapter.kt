package com.example.languagemap.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.languagemap.R
import com.example.languagemap.data.learnedItemsList
import com.example.languagemap.data.sharedPref

import com.example.languagemap.databinding.RowItemBinding
import com.example.languagemap.model.Items
import com.example.languagemap.view.HomeFragmentDirections
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson

class HomeAdapter(
    var wordList: MutableSet<Items>,
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Items) {
            with(binding) {
                recyclerViewText.text = items.name_tr
                recyclerViewTranslatedText.text = items.name_en
                itemImage.setImageResource(items.image)
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
        val currentItem = wordList.elementAt(position)

        holder.binding.recyclerViewCard.setOnClickListener {

            val action = HomeFragmentDirections.actionHomeFragmentToItemClickedFragment(currentItem)
            findNavController(it).navigate(action)
        }
    }
}