package com.example.coding_challenge_ota.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.coding_challenge_ota.data.datasource.local.db.dao.UserDao
import com.example.coding_challenge_ota.data.datasource.local.db.entity.UserEntity
import com.example.coding_challenge_ota.data.datasource.local.db.utils.DataTypeConverters

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
@TypeConverters(value = [DataTypeConverters::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}