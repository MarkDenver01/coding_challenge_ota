package com.example.coding_challenge_ota.data.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coding_challenge_ota.data.datasource.local.db.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM User WHERE userName =:userName")
    suspend fun retrieveLevel(userName: String?): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLevel(userEntity: UserEntity)
}