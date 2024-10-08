package com.example.coding_challenge_ota.domain.usecases

import com.example.coding_challenge_ota.data.datasource.local.db.entity.JourneyStatus
import com.example.coding_challenge_ota.data.datasource.local.db.entity.UserEntity
import com.example.coding_challenge_ota.data.repository.LevelRepository
import javax.inject.Inject

class LevelUseCase @Inject constructor(
    private val levelRepository: LevelRepository
) {
    suspend operator fun invoke(): UserEntity = levelRepository.getUserLevel()
}