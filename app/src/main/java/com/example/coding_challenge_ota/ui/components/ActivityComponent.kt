package com.example.coding_challenge_ota.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coding_challenge_ota.utils.downloader.FileDownloader
import com.example.coding_challenge_ota.domain.model.Activity
import com.example.coding_challenge_ota.domain.model.iconFileName
import com.example.coding_challenge_ota.domain.model.iconUrl
import com.example.coding_challenge_ota.ui.theme.Coding_challenge_otaTheme

@Composable
fun ActivityComponent(
    modifier: Modifier = Modifier,
    isLocked: Boolean,
    activity: Activity
) {
    val context = LocalContext.current
    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(activity) {
        val filename = activity.iconFileName(isLocked)

        imageBitmap = FileDownloader.downloadPdfAsImageBitmap(
            context = context,
            url = activity.iconUrl(isLocked),
            filename = filename
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        imageBitmap?.let {
            Image(
                bitmap = it,
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(145.dp, 132.dp)
            )
        } ?: Box(
            modifier = Modifier
                .size(145.dp, 132.dp)
                .background(
                    color = Color.LightGray.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(24.dp)
                )
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        Text(
            text = activity.title,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 10.dp)
                .width(145.dp)
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun LessonItemPreview() {
    Coding_challenge_otaTheme(modifier = Modifier.fillMaxSize()) {
        FlowRow(
            maxItemsInEachRow = 2,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 23.5.dp)
        ) {
            ActivityComponent(
                modifier = Modifier.weight(1f),
                isLocked = false,
                activity = Activity.Sample,

            )
            ActivityComponent(
                modifier = Modifier.weight(1f),
                isLocked = true,
                activity = Activity.Sample,
            )
            ActivityComponent(
                modifier = Modifier.weight(1f),
                isLocked = true,
                activity = Activity.Sample,
            )
        }
    }
}