package com.example.coding_challenge_ota.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.jetbrains.annotations.ApiStatus.Experimental

@Composable
fun MainApp() {
    Coding_challenge_otaTheme {
        val navController = rememberNavController()
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {  }
    }
}