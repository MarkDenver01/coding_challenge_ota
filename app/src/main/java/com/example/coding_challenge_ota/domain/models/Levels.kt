package com.example.coding_challenge_ota.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Levels(
    @SerialName("levels")
    val levels: List<Level>
)