package com.example.coding_challenge_ota.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coding_challenge_ota.domain.models.Level
import com.example.coding_challenge_ota.domain.usecases.LevelUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LevelViewModel @Inject constructor(
    private val levelUseCase: LevelUseCase
) : ViewModel() {
    private val levelMutable = MutableStateFlow(emptyList<Level>())
    val levelsAsStateFlow: StateFlow<List<Level>> = levelMutable.asStateFlow()

    fun retrieveLevel(userName: String) =
        viewModelScope.launch { levelMutable.emit(levelUseCase(userName)) }
}