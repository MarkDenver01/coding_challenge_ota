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
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coding_challenge_ota.R
import com.example.coding_challenge_ota.ui.theme.Coding_challenge_otaTheme

@Composable
fun HeaderComponent(
    modifier: Modifier = Modifier,
    progress: Float,
    progressStatus: String,
    dayStreak: Int,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 58.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_journey_status),
            contentDescription = null,
            modifier = Modifier.size(35.dp)
        )
        ProgressHeader(
            progress = progress,
            progressStatus = progressStatus,
            modifier = Modifier.padding(start = 12.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        StreakHeader(
            dayStreak = dayStreak
        )
        UserIconHeader(
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
private fun ProgressHeader(
    progress: Float,
    progressStatus: String,
    modifier: Modifier = Modifier
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

    LaunchedEffect(progress) {
        animate = true
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier
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
            modifier = Modifier.size(40.dp)
        )
        Text(
            text = "$dayStreak",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 45.sp
        )
    }
}

@Composable
private fun UserIconHeader(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
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
            .size(45.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_myaccount_round_thumbnail),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(45.dp, 45.dp)
        )
    }
}

@Preview
@Composable
private fun HeaderPreview() {
    Coding_challenge_otaTheme(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderComponent(
                modifier = Modifier.fillMaxWidth(),
                progress = 0.5f,
                progressStatus = "Taming Temper",
                dayStreak = 0,
            )
        }
    }
}