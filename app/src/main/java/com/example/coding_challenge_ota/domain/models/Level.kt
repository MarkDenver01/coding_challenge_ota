package com.example.coding_challenge_ota.domain.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Level(
    @SerialName("level")
    val level: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("state")
    val state: LevelState,
    @SerialName("activities")
    val activities: List<Activity>
) {
    companion object {
        @Ignore
        val Sample = Level(
            activities = listOf(Activity.Sample, Activity.Sample, Activity.Sample),
            description = "Collect your personalised techniques to beat Anxiety",
            level = "1",
            state = LevelState.AVAILABLE,
            title = "Find your tools"
        )
    }
}

enum class LevelState {
    AVAILABLE,
    LOCKED
}