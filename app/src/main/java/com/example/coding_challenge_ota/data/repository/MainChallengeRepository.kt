package com.example.coding_challenge_ota.data.repository

import com.example.coding_challenge_ota.data.datasource.local.LocalDataSource
import com.example.coding_challenge_ota.domain.interfaces.repo.MainChallenge
import com.example.coding_challenge_ota.domain.model.Level
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainChallengeRepository @Inject constructor(
    private val localDataSource: LocalDataSource
) : MainChallenge {
    override suspend fun fetchAll(): List<Level> = withContext(Dispatchers.IO) {
        localDataSource.fetchAll()
    }

    override suspend fun insertAll(levels: List<Level>) = withContext(Dispatchers.IO) {
        localDataSource.insertAll(levels)
    }

    override suspend fun deleteAll() = withContext(Dispatchers.IO) {
        localDataSource.deleteAll()
    }
}