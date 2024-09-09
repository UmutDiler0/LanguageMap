package com.example.languagemap.viewmodel

import androidx.lifecycle.ViewModel
import com.example.languagemap.model.Items
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class LearnedViewModel: ViewModel() {

    private var _learnedState = MutableStateFlow(mutableSetOf<Items>())
    val learnedState get() = _learnedState

    fun addLearned(mutableList: MutableSet<Items>){
        _learnedState.update{
            it.add(Items(mutableList.elementAt(0).word, mutableList.elementAt(0).translated))
            it
        }
    }
}