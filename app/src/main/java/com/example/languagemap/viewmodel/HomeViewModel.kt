package com.example.languagemap.viewmodel

import androidx.lifecycle.ViewModel
import com.example.languagemap.data.initWordsList
import com.example.languagemap.model.Items
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class HomeUiState(
    val items: List<Items> = emptyList(),
    val isShuffled: Boolean= false
)

class HomeViewModel: ViewModel() {

    private var _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState


    fun shuffleItemsForOnce(){
        if (_homeUiState.value.isShuffled.not()){
            _homeUiState.update{
                it.copy(
                    items = initWordsList.shuffled(),
                    isShuffled = true
                )
            }
            initWordsList = _homeUiState.value.items.toMutableSet()
        }
    }

    fun updateCurrentList(){
        _homeUiState.update{state->
            state.copy(
                items = initWordsList.toList(),
                isShuffled = true
            )
        }
        initWordsList = _homeUiState.value.items.toMutableSet()
    }

    fun shuflleItems(){
        _homeUiState.update{
            it.copy(
                items = initWordsList.shuffled(),
                isShuffled = true
            )
        }
        initWordsList = _homeUiState.value.items.toMutableSet()
    }

}