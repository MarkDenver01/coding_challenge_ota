package com.example.coding_challenge_ota.domain.interfaces.local

import com.example.coding_challenge_ota.domain.model.Level

interface Local {
    suspend fun fetchAll(): List<Level>

    suspend fun insertAll(levels: List<Level>)

    suspend fun deleteAll()
}