package com.example.coding_challenge_ota.data.datasource.local

import com.example.coding_challenge_ota.data.datasource.local.db.dao.UserDao
import com.example.coding_challenge_ota.data.datasource.local.db.entity.UserEntity
import com.example.coding_challenge_ota.domain.repository.Local
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val userDao: UserDao
) : Local {
    override suspend fun retrieveLevel(userName: String): UserEntity =
        userDao.retrieveLevel(userName)

    override suspend fun insertUser(userEntity: UserEntity) {
        userDao.insertUser(userEntity)
    }

    override suspend fun deleteUser(userName: String) {
        userDao.deleteUser(userName)
    }
}