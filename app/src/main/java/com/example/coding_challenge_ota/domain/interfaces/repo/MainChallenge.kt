package com.example.coding_challenge_ota.domain.interfaces.repo

import com.example.coding_challenge_ota.domain.model.Level

interface MainChallenge {
    suspend fun fetchAll(): List<Level>

    suspend fun insertAll(levels: List<Level>)

    suspend fun deleteAll()
}