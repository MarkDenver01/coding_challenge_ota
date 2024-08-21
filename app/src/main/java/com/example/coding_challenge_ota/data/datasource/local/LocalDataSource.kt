package com.example.coding_challenge_ota.data.datasource.local

import com.example.coding_challenge_ota.data.datasource.local.dao.LevelDao
import com.example.coding_challenge_ota.domain.interfaces.local.Local
import com.example.coding_challenge_ota.domain.model.Level
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val levelDao: LevelDao
) : Local {

    override suspend fun fetchAll(): List<Level> = withContext(Dispatchers.IO) {
        levelDao.fetchAll()
    }

    override suspend fun insertAll(levels: List<Level>) = withContext(Dispatchers.IO) {
        levelDao.insertAll(levels)
    }

    override suspend fun deleteAll() = withContext(Dispatchers.IO) {
        levelDao.deleteAll()
    }
}