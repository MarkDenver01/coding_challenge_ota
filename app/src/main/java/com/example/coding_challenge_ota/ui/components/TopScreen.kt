package com.example.coding_challenge_ota.ui.components


import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coding_challenge_ota.R
import com.example.coding_challenge_ota.ui.theme.Coding_challenge_otaTheme

@Composable
fun TopScreen(
    modifier: Modifier = Modifier,
    progress: Float,
    progressStatus: String,
    dayStreak: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.drawable.ic_journey_status),
            contentDescription = null
        )
        ProgressHeader(
            modifier = Modifier.padding(start = 12.dp),
            progress = progress,
            progressStatus = progressStatus
        )
        Spacer(modifier = Modifier.weight(1f))
        StreakHeader(dayStreak = dayStreak)
        UserIconHeader(modifier = Modifier.padding(start = 16.dp))
    }
}

@Composable
private fun ProgressHeader(
    modifier: Modifier = Modifier,
    progress: Float,
    progressStatus: String
) {
    var animate by remember { mutableStateOf(false) }
    val progressValue by animateFloatAsState(
        targetValue = if (animate) progress else 0f,
        animationSpec = tween(
            durationMillis = 2000,
            delayMillis = 1000,
            easing = EaseInOutCubic
        ),
        label = "progress animation"
    )

    LaunchedEffect(progress) { animate = true }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = progressStatus,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 18.sp
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LinearProgressIndicator(
                progress = { progressValue },
                modifier = Modifier
                    .size(72.dp, 4.dp)
                    .clip(shape = RoundedCornerShape(50))
            )
            Text(
                text = "%.0f%%".format(progressValue * 100),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 10.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 15.sp
            )
        }
    }
}

@Composable
private fun StreakHeader(
    dayStreak: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_fire),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "$dayStreak",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 26.sp
        )
    }
}

@Composable
private fun UserIconHeader(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .shadow(elevation = 4.dp, shape = CircleShape)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = CircleShape
            )
            .let {
                if (isSystemInDarkTheme()) it.border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = CircleShape
                ) else it
            }
            .size(40.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_myaccount_round_thumbnail),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(40.dp)
        )
    }
}

@Preview
@Composable
private fun HeaderPreview() {
    Coding_challenge_otaTheme(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopScreen(
                progress = 0.03f,
                progressStatus = "Taming Temper",
                dayStreak = 0,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
