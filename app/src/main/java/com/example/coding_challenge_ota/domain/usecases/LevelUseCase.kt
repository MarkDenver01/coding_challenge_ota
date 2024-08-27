package com.example.coding_challenge_ota.domain.usecases

import com.example.coding_challenge_ota.data.repository.LevelRepository
import javax.inject.Inject

class LevelUseCase @Inject constructor(
    private val levelRepository: LevelRepository
) {
    suspend operator fun invoke(userName: String) = levelRepository.getLevels(userName)
}