package com.example.coding_challenge_ota.data.datasource.local.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.coding_challenge_ota.domain.models.Level
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class UserEntity(
    @PrimaryKey
    @SerialName("userName")
    val userName: String,
    @SerialName("firePoints")
    val firePoints: Int,
    @SerialName("levels")
    val levels : List<Level>
)