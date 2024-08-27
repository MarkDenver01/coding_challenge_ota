package com.example.coding_challenge_ota.data.datasource.local.db.utils

import androidx.room.TypeConverter
import com.example.coding_challenge_ota.domain.models.Activity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TypeConverter {
    @TypeConverter
    fun jsonEncode(data: List<Activity>): String = Json.encodeToString(data)

    @TypeConverter
    fun jsonDecode(data: String): List<Activity> = Json.decodeFromString(data)
}