package com.example.coding_challenge_ota.domain.entity


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

    }
}

enum class State {
    AVAILABLE,
    LOCKED
}