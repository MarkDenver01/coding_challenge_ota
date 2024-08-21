package com.example.coding_challenge_ota.domain.response

import com.example.coding_challenge_ota.domain.model.Level
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SampleApiResponse(
    @SerialName("levels")
    val levels: List<Level>
) {
    companion object {
        // TODO
    }
}