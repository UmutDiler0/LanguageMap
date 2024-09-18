package com.example.languagemap.viewmodel

import androidx.lifecycle.ViewModel
import com.example.languagemap.data.initWordsList
import com.example.languagemap.model.Items
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class HomeUiState(
    val items: List<Items> = emptyList(),
    val isShuffled: Boolean = false,
)

class HomeViewModel : ViewModel() {

    private var _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState

    fun shuffleItemsForOnce() {
        if (_homeUiState.value.isShuffled.not()) {
            val shuflledList = initWordsList.shuffled()
            _homeUiState.update {
                it.copy(
                    items = shuflledList,
                    isShuffled = true
                )
            }
            initWordsList = shuflledList.toMutableList()
        }
    }

    fun getCurrentState() {

        _homeUiState.update {
            it.copy(
                items = _homeUiState.value.items,
            )
        }
    }

    fun shuflleItems() {
        val shuflledList = initWordsList.shuffled()
        _homeUiState.update {
            it.copy(
                items = shuflledList,
            )
        }
        initWordsList = shuflledList.toMutableList()
    }

    fun removeItemFromList(itemId: Items) {
        _homeUiState.update{
            it.copy(
                items = _homeUiState.value.items.filter { it != itemId }
            )
        }
    }

    fun addItemToList(itemId: Items) {
        _homeUiState.update{
            it.copy(
                items = _homeUiState.value.items + itemId
            )
        }
    }

}