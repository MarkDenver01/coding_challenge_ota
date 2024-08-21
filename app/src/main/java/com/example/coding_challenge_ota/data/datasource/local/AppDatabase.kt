package com.example.coding_challenge_ota.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.coding_challenge_ota.data.datasource.local.dao.LevelDao
import com.example.coding_challenge_ota.domain.entity.User
import com.example.coding_challenge_ota.utils.EntityConverters

@Database(
    entities = [User::class],
    version = 1
)
@TypeConverters(EntityConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun levelDao(): LevelDao
}