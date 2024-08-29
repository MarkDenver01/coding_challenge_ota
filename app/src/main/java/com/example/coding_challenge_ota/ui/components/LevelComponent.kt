package com.example.coding_challenge_ota.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coding_challenge_ota.R
import com.example.coding_challenge_ota.domain.models.Activity
import com.example.coding_challenge_ota.domain.models.Level
import com.example.coding_challenge_ota.domain.models.LevelState
import com.example.coding_challenge_ota.domain.models.Levels
import com.example.coding_challenge_ota.ui.theme.Coding_challenge_otaTheme
import com.example.coding_challenge_ota.ui.theme.TextPrimary
import com.example.coding_challenge_ota.ui.theme.TextSecondary

@Composable
fun LevelComponent(
    modifier: Modifier = Modifier,
    level: Level
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Box(
            modifier = Modifier.size(120.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .width(102.dp)
                    .height(86.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_challenge_chapter),
                contentDescription = "Level ${level.level ?: 0}"
            )

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(TextPrimary)
                    .align(Alignment.BottomCenter),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                    text = "Level ${level.level ?: 0}".uppercase(),
                    color = Color.White,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
        Spacer(Modifier.height(8.dp))

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = level.title ?: "---",
            style = MaterialTheme.typography.labelLarge,
        )
        Spacer(Modifier.height(8.dp))

        // Level Description
        Text(
            modifier = Modifier.padding(horizontal = 32.dp),
            text = level.description,
            style = MaterialTheme.typography.labelMedium,
            color = TextSecondary,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(8.dp))

        when (level.activities.isEmpty()) {
            true -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "No activity",
                        style = MaterialTheme.typography.displayMedium,
                        textAlign = TextAlign.Center,
                    )
                }
            }

            false -> {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(
                            ((160 * (level.activities.size / 2)) + (24 * (level.activities.size / 2))).dp
                        ),
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.Center,
                    userScrollEnabled = false
                ) {
                    items(
                        count = level.activities.size,
                        key = { index -> index },
                        span = { index ->
                            if (index == level.activities.size - 1 && index % 2 == 0) {
                                GridItemSpan(2)
                            } else {
                                GridItemSpan(1)
                            }

                        },
                    ) { index ->
                        val activityItem = level.activities[index]
                        ActivityComponent(activity = activityItem)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun LevelItemPreview() {
    Coding_challenge_otaTheme(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            LevelComponent(
                level = Level.dummy,
                modifier = Modifier.fillMaxWidth()
            )
            LevelComponent(
                level = Level.dummy.copy(level = "2", state = LevelState.LOCKED),
                modifier = Modifier.fillMaxWidth()
            )
            LevelComponent(
                level = Level.dummy.copy(level = "3", state = LevelState.LOCKED),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}