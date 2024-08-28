package com.example.coding_challenge_ota.data.datasource.local.db.utils

import androidx.room.TypeConverter
import com.example.coding_challenge_ota.data.datasource.local.db.entity.UserEntity
import com.example.coding_challenge_ota.domain.models.Level
import com.example.coding_challenge_ota.domain.models.Levels
import com.google.gson.Gson

class DataTypeConverters {
    @TypeConverter
    fun jsonEncode(data: UserEntity): String = Gson().toJson(data)

    @TypeConverter
    fun jsonDecode(data: String): UserEntity = Gson().fromJson(data, UserEntity::class.java)

    @TypeConverter
    fun jsonEncodeList(data: Levels): String = Gson().toJson(data)

    @TypeConverter
    fun jsonDecodeList(data: String): Levels = Gson().fromJson(data, Levels::class.java)
}