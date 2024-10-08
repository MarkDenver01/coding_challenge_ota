package com.example.coding_challenge_ota.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coding_challenge_ota.R
import com.example.coding_challenge_ota.data.datasource.local.db.entity.JourneyStatus
import com.example.coding_challenge_ota.ui.components.DayComponent
import com.example.coding_challenge_ota.ui.components.HeaderComponent
import com.example.coding_challenge_ota.ui.components.LevelComponent
import com.example.coding_challenge_ota.ui.viewmodels.LevelViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    levelViewModel: LevelViewModel = hiltViewModel()
) {
    val scroll = rememberLazyListState()
    val levelCollectState by levelViewModel.levelsAsStateFlow.collectAsState()

    LaunchedEffect(Unit) {
        levelViewModel.retrieveLevel()
    }

    Scaffold(
        modifier = Modifier.fillMaxHeight(),
        topBar = {
            MainHeader(
                progress = levelCollectState.journeyStatus.progress.toFloat() / 100,
                progressStatus = when (levelCollectState.journeyStatus.journeyState) {
                    JourneyStatus.JourneyState.Angry -> "Angry"
                    JourneyStatus.JourneyState.TamingTemper -> "Taming Temper"
                    JourneyStatus.JourneyState.Calm -> "Calm"
                    JourneyStatus.JourneyState.Interested -> "Interested"
                    JourneyStatus.JourneyState.Happy -> "Happy"
                },
                day = levelCollectState.firePoints,
                scroll = scroll
            )
        },
        bottomBar = { MainFooter() }
    ) { contentPadding ->
        LazyColumn(
            state = scroll,
            contentPadding = contentPadding,
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(
                items = levelCollectState.levels.levels,
                key = { _, level -> level.level }
            ) { index, level ->
                Spacer(modifier = Modifier.height(if (index == 0) 32.dp else 40.dp))
                LevelComponent(
                    modifier = Modifier.fillMaxWidth(),
                    level = level
                )
            }
            item { Spacer(modifier = Modifier.height(40.dp)) }
        }
    }
}

@Composable
private fun MainHeader(
    progress: Float,
    progressStatus: String,
    day: Int,
    scroll: LazyListState
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
    ) {
        HeaderComponent(
            modifier = Modifier.fillMaxWidth(),
            progress = progress,
            progressStatus = progressStatus,
            dayStreak = day
        )

        Spacer(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiary)
                .fillMaxWidth()
                .height(1.dp)
        )

        DayComponent(
            modifier = Modifier.fillMaxWidth(),
            onTabSelected = { index ->
                scope.launch { scroll.animateScrollToItem(index) }
            }
        )
    }
}

@Composable
private fun MainFooter() {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
    ) {
        Spacer(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiary)
                .fillMaxWidth()
                .height(1.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(11.dp)

        ) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_journey),
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.journey),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 12.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}