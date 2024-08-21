package com.example.coding_challenge_ota.utils

import androidx.room.TypeConverter
import com.example.coding_challenge_ota.domain.model.Activity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class EntityConverters {
    @TypeConverter
    fun activityListToString(value: List<Activity>): String =
        Json.encodeToString(value)

    @TypeConverter
    fun stringToActivityList(value: String): List<Activity> =
        Json.decodeFromString(value)
}