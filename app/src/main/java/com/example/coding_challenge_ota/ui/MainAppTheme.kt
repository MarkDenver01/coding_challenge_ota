package com.example.coding_challenge_ota.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.coding_challenge_ota.ui.theme.Coding_challenge_otaTheme

@Composable
fun MainAppTheme() {
    val navController = rememberNavController()
    Coding_challenge_otaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainNavGraph(
                navController = navController,
                startDestination = MainDestination.HOME
            )
        }
    }
}