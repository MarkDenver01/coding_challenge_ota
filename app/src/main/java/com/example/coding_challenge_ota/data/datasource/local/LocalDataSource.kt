package com.example.coding_challenge_ota.data.datasource.local

import com.example.coding_challenge_ota.data.datasource.local.db.dao.UserDao
import com.example.coding_challenge_ota.data.datasource.local.db.entity.UserEntity
import com.example.coding_challenge_ota.domain.repository.Local
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val userDao: UserDao
) : Local {

    override suspend fun retrieveLevel(username: String): UserEntity =
        withContext(Dispatchers.IO) {
            userDao.retrieveLevel(username)
        }

    override suspend fun insertLevel(userEntity: UserEntity) {
        userDao.insertLevel(userEntity)
    }
}