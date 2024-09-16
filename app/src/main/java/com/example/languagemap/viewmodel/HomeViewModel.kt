package com.example.languagemap.viewmodel

import androidx.lifecycle.ViewModel
import com.example.languagemap.data.initWordsList
import com.example.languagemap.model.Items
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel: ViewModel() {

    private var _itemsState = MutableStateFlow(listOf<Items>())
    val itemsState get() = _itemsState
    private var isShuffled = false

    fun shuffleItemsForOnce(){
        if (!isShuffled) {
            _itemsState.update{
                initWordsList.shuffled().toMutableList()
            }
            isShuffled = true
        }
    }

    fun getCurrentList(){
            _itemsState.update{
            initWordsList.toList()
        } }

    fun shuflleItems(){
        _itemsState.update{
            initWordsList.shuffled()
        }
    }
}