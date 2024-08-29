package com.example.coding_challenge_ota.data.datasource.remote.dto

import com.example.coding_challenge_ota.domain.models.Level
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LevelDto(
    @SerialName("statusCode")
    val statusCode: Int,
    @SerialName("levels")
    val levels: List<Level>
)