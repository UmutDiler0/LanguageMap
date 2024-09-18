package com.example.languagemap.viewmodel

import androidx.lifecycle.ViewModel
import com.example.languagemap.data.learnedItemsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class LearnUiState(
    val isLearnedListEmpty: Boolean,
)

class LearnViewModel: ViewModel() {

    private var _learnState = MutableStateFlow(LearnUiState(false))
    val learnState: StateFlow<LearnUiState> = _learnState

    fun checkLearnedList() {
        if (learnedItemsList.isEmpty()) {
            _learnState.update {
                it.copy(isLearnedListEmpty = true)
            }
        } else {
            _learnState.update {
                it.copy(isLearnedListEmpty = false)
            }
        }
    }
}