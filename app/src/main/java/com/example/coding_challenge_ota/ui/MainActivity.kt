package com.example.coding_challenge_ota.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.coding_challenge_ota.ui.navigation.Screen
import com.example.coding_challenge_ota.ui.navigation.mainNavigation
import com.example.coding_challenge_ota.ui.screen.HomeScreen
import com.example.coding_challenge_ota.ui.theme.Coding_challenge_otaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            Coding_challenge_otaTheme(
                modifier = Modifier.fillMaxSize()
            ) {
                NavHost(navController = navController, startDestination = Screen.Home.route) {
                    mainNavigation(navController)
                }
            }
        }
    }
}