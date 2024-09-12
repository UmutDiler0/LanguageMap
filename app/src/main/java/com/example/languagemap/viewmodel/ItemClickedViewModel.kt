package com.example.languagemap.viewmodel

import androidx.lifecycle.ViewModel
import com.example.languagemap.data.initWordsList
import com.example.languagemap.model.Items
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class ItemClickedViewModel: ViewModel() {

    private var _itemsState = MutableStateFlow(listOf<Items>())
    val itemsState get() = _itemsState

    fun getCurrentState(){
        _itemsState.update{
            initWordsList.toList()
        }
    }
}