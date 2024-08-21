package com.example.coding_challenge_ota.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coding_challenge_ota.ui.theme.Coding_challenge_otaTheme
import com.example.coding_challenge_ota.ui.theme.LightGray

private val days = listOf(
    "MON",
    "TUE",
    "WED",
    "THU",
    "FRI",
    "SAT",
    "SUN",
)

@Composable
fun DayComponent(
    modifier: Modifier = Modifier,
    onTabSelected: (index: Int) -> Unit,
) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        modifier = modifier
    ) {
        days.forEachIndexed { index, day ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .clickable {
                        selectedTabIndex = index
                        onTabSelected(index)
                    }
                    .fillMaxSize()
                    .padding(top = 4.dp, bottom = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(16.dp)
                        .let {
                            if (index == selectedTabIndex) it.background(MaterialTheme.colorScheme.primary, CircleShape)
                            else it.border(width = 1.dp, color = LightGray, shape = CircleShape)
                        }
                )
                Text(
                    text = day,
                    color = if (index == selectedTabIndex) MaterialTheme.colorScheme.primary
                    else LightGray,
                )
            }
        }
    }
}

@Preview
@Composable
fun DayTabsPreview() {
    Coding_challenge_otaTheme(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            DayComponent(
                modifier = Modifier.fillMaxWidth(),
                onTabSelected = {},
            )
        }
    }
}