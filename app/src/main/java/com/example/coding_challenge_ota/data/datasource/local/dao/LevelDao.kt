package com.example.coding_challenge_ota.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.coding_challenge_ota.domain.model.Level

@Dao
interface LevelDao {

    @Query("SELECT * FROM User")
    fun fetchAll(): List<Level>

    @Insert
    suspend fun insertAll(levels: List<Level>)

    @Query("Delete FROM User")
    suspend fun deleteAll()
}