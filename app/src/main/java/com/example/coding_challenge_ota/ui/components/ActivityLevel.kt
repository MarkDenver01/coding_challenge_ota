package com.example.coding_challenge_ota.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coding_challenge_ota.R
import com.example.coding_challenge_ota.domain.entity.Level

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ActivityLevel(
    modifier: Modifier = Modifier,
    level: Level
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .padding(bottom = 14.dp)
                        .size(102.dp, 86.dp),
                    painter = painterResource(id = R.drawable.ic_challenge_chapter),
                    contentDescription = null
                )
                Text(
                    text = stringResource(0, level.level), // TODO
                    color = MaterialTheme.colorScheme.background,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .background(
                            color = MaterialTheme.colorScheme.onBackground,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                )
            }
            Column(
                modifier = Modifier.padding(horizontal = 64.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = level.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = level.description,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        FlowRow(
            modifier = Modifier,
            maxItemsInEachRow = 2,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // TODO
        }
    }
}