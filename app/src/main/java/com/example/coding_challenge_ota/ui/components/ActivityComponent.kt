package com.example.coding_challenge_ota.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coding_challenge_ota.R
import com.example.coding_challenge_ota.domain.models.Activity
import com.example.coding_challenge_ota.domain.models.ActivityState
import com.example.coding_challenge_ota.domain.models.ActivityType
import com.example.coding_challenge_ota.domain.models.Details
import com.example.coding_challenge_ota.domain.models.Icon
import com.example.coding_challenge_ota.domain.models.IconFile
import com.example.coding_challenge_ota.ui.theme.Coding_challenge_otaTheme
import java.util.UUID
import kotlin.random.Random

@Composable
fun ActivityComponent(
    modifier: Modifier = Modifier,
    activity: Activity
) {
    Column(
        modifier = modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box {
            Image(
                modifier = Modifier
                    .width(124.dp)
                    .height(112.dp)
                    .padding(6.dp)
                    .clip(RoundedCornerShape(24.dp)),
                imageVector = ImageVector.vectorResource(
                    id = when (activity.type) {
                        ActivityType.RECAP -> R.drawable.ic_activity_image_1
                        ActivityType.COMMIT -> R.drawable.ic_activity_image_2
                        ActivityType.PRACTICE -> R.drawable.ic_activity_image_3
                        else -> R.drawable.ic_techniques
                    }
                ),
                contentDescription = "Activity ${activity.id}"
            )

            if (activity.state == ActivityState.DONE) {
                Image(
                    modifier = Modifier
                        .size(28.dp)
                        .align(Alignment.TopEnd),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_checkmark),
                    contentDescription = "Activity State ${activity.state.name}"
                )
            }
        }
        Text(
            modifier = Modifier.padding(horizontal = 6.dp),
            text = activity.title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview(widthDp = 160, heightDp = 160)
@Composable
fun ActivityComponentItemView_NotSet() {
    Coding_challenge_otaTheme {
        Surface {
            ActivityComponent(
                modifier = Modifier,
                activity = run {
                    val randomIndex = Random.nextInt(10)
                    val activityId = UUID.randomUUID().toString()
                    val iconIndex = Random.nextInt(Dummy.ActiveIcons.size)
                    Activity(
                        id = activityId,
                        challengeId = activityId.substring(0..(activityId.length / 2)),
                        type = ActivityType.entries.random(),
                        title = "Activity Title #$randomIndex",
                        titleB = null,
                        description = "This is some description for activity #$randomIndex",
                        descriptionB = null,
                        state = ActivityState.NOT_SET,
                        icon = Dummy.ActiveIcons[iconIndex],
                        lockedIcon = Dummy.LockedIcons[iconIndex]
                    )
                }
            )
        }
    }
}

@Preview(widthDp = 160, heightDp = 160)
@Composable
fun ActivityComponentItemView_Done() {
    Coding_challenge_otaTheme {
        Surface {
            ActivityComponent(
                modifier = Modifier,
                activity = run {
                    val randomIndex = Random.nextInt(10)
                    val activityId = UUID.randomUUID().toString()
                    val iconIndex = Random.nextInt(Dummy.ActiveIcons.size)
                    Activity(
                        id = activityId,
                        challengeId = activityId.substring(0..(activityId.length / 2)),
                        type = ActivityType.entries.random(),
                        title = "Activity Title #$randomIndex",
                        titleB = null,
                        description = "This is some description for activity #$randomIndex",
                        descriptionB = null,
                        state = ActivityState.DONE,
                        icon = Dummy.ActiveIcons[iconIndex],
                        lockedIcon = Dummy.LockedIcons[iconIndex]
                    )
                }
            )
        }
    }
}

internal object Dummy {
    val ActiveIcons = listOf(
        Icon(
            file = IconFile(
                url = "//assets.ctfassets.net/37k4ti9zbz4t/DVQrkzmSp53EXqmFn9z1L/f4270b3b29c508c04493ead947e8651f/Chapter_01__Lesson_02__State_Active.pdf",
                details = Details(size = 5998),
                fileName = "Chapter_01__Lesson_02__State_Active.pdf",
                contentType = "application/pdf",
            ),
            title = "Chapter=01, Lesson=02, State=Active",
            description = ""
        ),
        Icon(
            file = IconFile(
                url = "//assets.ctfassets.net/37k4ti9zbz4t/7qfuLW6KOLr5wARa6y1iiJ/d9fe08d9680ebe8fa1d02b056e9d9f61/Chapter_05__Lesson_02__State_Active.pdf",
                details = Details(size = 9671),
                fileName = "Chapter_05__Lesson_02__State_Active.pdf",
                contentType = "application/pdf",
            ),
            title = "Chapter 05 Lesson 02 State Active",
            description = ""
        ),
        Icon(
            file = IconFile(
                url = "//assets.ctfassets.net/37k4ti9zbz4t/4gLO4SNpkWwF8t0RFRPTC/34bdc756deee0b3e089d4c7248fec8b5/Chapter_03__Lesson_02__State_Active.pdf",
                details = Details(size = 18722),
                fileName = "Chapter_03__Lesson_02__State_Active.pdf",
                contentType = "application/pdf",
            ),
            title = "Chapter 03 Lesson 02 State Active",
            description = ""
        ),
    )

    val LockedIcons = listOf(
        Icon(
            file = IconFile(
                url = "//assets.ctfassets.net/37k4ti9zbz4t/1aknm1E9St7J2mIKPeerI8/e937194308275460c2facda7d09cf9e7/Chapter_01__Lesson_02__State_Locked.pdf",
                details = Details(size = 5998),
                fileName = "Chapter_01__Lesson_02__State_Locked.pdf",
                contentType = "application/pdf",
            ),
            title = "Chapter=01, Lesson=02, State=Locked",
            description = ""
        ),
        Icon(
            file = IconFile(
                url = "//assets.ctfassets.net/37k4ti9zbz4t/60XAuyMCfdyX8vz3uMwPTW/97811784b538551493416bdc6b279f85/Chapter_05__Lesson_02__State_Locked.pdf",
                details = Details(size = 9671),
                fileName = "Chapter_05__Lesson_02__State_Locked.pdf",
                contentType = "application/pdf",
            ),
            title = "Chapter 05 Lesson 02 State Locked",
            description = ""
        ),
        Icon(
            file = IconFile(
                url = "///assets.ctfassets.net/37k4ti9zbz4t/31thfjGB33eySuuaqMaZj7/e5694a459af89744c17377313b43cb96/Chapter_03__Lesson_02__State_Locked.pdf",
                details = Details(size = 18722),
                fileName = "Chapter_03__Lesson_02__State_Locked.pdf",
                contentType = "application/pdf",
            ),
            title = "Chapter 03 Lesson 02 State Locked",
            description = ""
        ),
    )

}