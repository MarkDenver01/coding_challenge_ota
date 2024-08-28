package com.example.coding_challenge_ota.data.datasource.local.db.entity

import androidx.room.Entity
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
    @SerialName("levels")
    val levels: Levels
) {
    companion object {
        val MockUser = UserEntity(
            userName = "Denver",
            firePoints = 258,
            levels = Levels(listOf(Level.dummy))
        )
    }
}