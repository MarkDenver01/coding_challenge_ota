package com.example.coding_challenge_ota.data.datasource.local.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.coding_challenge_ota.domain.models.Level
import com.example.coding_challenge_ota.domain.models.Levels
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "User")
@Serializable
data class UserEntity(
    @PrimaryKey
    @SerialName("userName")
    val userName: String,
    @SerialName("firePoints")
    val firePoints: Int,
    @Embedded
    @SerialName("journeyStatus")
    val journeyStatus: JourneyStatus,
    @SerialName("levels")
    val levels: Levels
)

@Serializable
data class JourneyStatus(
    @SerialName("progress")
    val progress: Int
) {
    @Ignore
    val journeyState: JourneyState = when (progress) {
        in 0..20 -> JourneyState.Angry

        in 21..40 -> JourneyState.TamingTemper


        in 41..60 -> JourneyState.Calm


        in 61..80 -> JourneyState.Interested

        else -> JourneyState.Happy
    }

    @Serializable
    enum class JourneyState {
        @SerialName("Angry")
        Angry,

        @SerialName("TamingTemper")
        TamingTemper,

        @SerialName("Calm")
        Calm,

        @SerialName("Interested")
        Interested,

        @SerialName("Happy")
        Happy
    }
}