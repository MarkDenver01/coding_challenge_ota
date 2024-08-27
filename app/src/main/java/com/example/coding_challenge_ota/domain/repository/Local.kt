package com.example.coding_challenge_ota.domain.repository

import com.example.coding_challenge_ota.data.datasource.local.db.entity.UserEntity

interface Local {
    suspend fun retrieveLevel(userName: String): UserEntity

    suspend fun insertUser(userEntity: UserEntity)

    suspend fun deleteUser(userName: String)
}