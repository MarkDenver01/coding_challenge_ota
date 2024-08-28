package com.example.coding_challenge_ota.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coding_challenge_ota.data.datasource.local.db.entity.UserEntity
import com.example.coding_challenge_ota.domain.models.Levels
import com.example.coding_challenge_ota.domain.usecases.LevelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelViewModel @Inject constructor(
    private val levelUseCase: LevelUseCase
) : ViewModel() {
    private val levelMutable = MutableStateFlow(UserEntity("", 0, Levels(emptyList())))
    val levelsAsStateFlow: StateFlow<UserEntity> = levelMutable.asStateFlow()

    suspend fun retrieveLevel() {
        Log.d(
            "xxxxx",
            " use case response: " + levelUseCase.invoke("denver", 287).levels.levels[0].title
        )
        viewModelScope.launch { levelMutable.emit(levelUseCase("denver", 287)) }
    }

}