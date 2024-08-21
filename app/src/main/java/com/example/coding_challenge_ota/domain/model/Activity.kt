package com.example.coding_challenge_ota.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Activity(
    @SerialName("id")
    val id: String,
    @SerialName("challengeId")
    val challengeId: String,
    @SerialName("type")
    val type: ActivityType,
    @SerialName("title")
    val title: String,
    @SerialName("titleB")
    val titleB: String,
    @SerialName("description")
    val description: String,
    @SerialName("descriptionB")
    val descriptionB: String,
    @SerialName("state")
    val state: ActivityState,
    @SerialName("icon")
    val icon: Icon,
    @SerialName("lockedIcon")
    val lockedIcon: Icon
) {
    companion object {
        val Sample = Activity(
            challengeId = "2ECefjj9gotSu1RzQYguQV",
            description = "When feeling anxious we tend to worry on repeat. And the more we worry, the more we feel anxious. It’s a vicious cycle. Let’s learn how to break out of it early.",
            descriptionB = "",
            icon = Icon.Sample,
            id = "2ECefjj9gotSu1RzQYguQV7FBMJel296NaotMcf3PwJ432uh72",
            lockedIcon = Icon.Sample,
            state = ActivityState.NOT_SET,
            title = "Break your worry chain reaction",
            titleB = "",
            type = ActivityType.PRACTICE
        )
    }
}

fun Activity.iconFileName(isLocked: Boolean) =
    if (isLocked) lockedIcon.file.fileName else icon.file.fileName

fun Activity.iconUrl(isLocked: Boolean) = if (isLocked) lockedIcon.file.url else icon.file.url

@Serializable
data class Icon(
    @SerialName("file")
    val `file`: File,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String
) {
    companion object {
        val Sample = Icon(
            description = "",
            file = File.Sample,
            title = "Chapter=01, Lesson=02, State=Active"
        )
    }
}

@Serializable
data class File(
    @SerialName("url")
    val url: String,
    @SerialName("details")
    val details: Details,
    @SerialName("fileName")
    val fileName: String,
    @SerialName("contentType")
    val contentType: String
) {
    companion object {
        val Sample = File(
            contentType = "application/pdf",
            details = Details.Sample,
            fileName = "Chapter_01__Lesson_02__State_Active.pdf",
            url = "//assets.ctfassets.net/37k4ti9zbz4t/DVQrkzmSp53EXqmFn9z1L/f4270b3b29c508c04493ead947e8651f/Chapter_01__Lesson_02__State_Active.pdf"
        )
    }
}

@Serializable
data class Details(
    @SerialName("size")
    val size: Int
) {
    companion object {
        val Sample = Details(
            size = 5998
        )
    }
}

enum class ActivityType {
    PRACTICE,
    COMMIT,
    RECAP
}

enum class ActivityState {
    NOT_SET,
    DONE
}