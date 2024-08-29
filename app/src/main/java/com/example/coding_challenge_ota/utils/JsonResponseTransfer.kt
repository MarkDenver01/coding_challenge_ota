package com.example.coding_challenge_ota.utils

import androidx.room.TypeConverter
import com.example.coding_challenge_ota.domain.models.Level
import com.example.coding_challenge_ota.domain.models.Levels
import com.google.gson.JsonObject
import kotlinx.serialization.json.Json
import retrofit2.Response

object JsonResponseTransfer {
    fun jsonTransfer(jsonResponse: Response<JsonObject>): Levels {
        return Json.decodeFromString(jsonResponse.body().toString())
    }
}