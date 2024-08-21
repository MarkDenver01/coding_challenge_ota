package com.example.coding_challenge_ota.domain.entity

import androidx.room.Entity
import com.example.coding_challenge_ota.domain.model.Level
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class User(
    @SerialName("username")
    val userName: String,
    @SerialName("fire_points")
    val firePoints: Int,
    @SerialName("level")
    val level: Level
) {
    companion object {
        val Sample = User(
            userName = "Denver",
            firePoints = 50,
            level = Level.Sample
        )
    }
}