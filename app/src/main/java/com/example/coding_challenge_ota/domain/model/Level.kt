package com.example.coding_challenge_ota.domain.model


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
    val state: State,
    @SerialName("activities")
    val activities: List<Activity>
) {
    companion object {
        val Sample = Level(
            activities = listOf(Activity.Sample, Activity.Sample, Activity.Sample),
            description = "Collect your personalised techniques to beat Anxiety",
            level = "1",
            state = State.AVAILABLE,
            title = "Find your tools"
        )
    }
}

enum class State {
    AVAILABLE,
    LOCKED
}