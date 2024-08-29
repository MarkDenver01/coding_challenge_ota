package com.example.coding_challenge_ota.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coding_challenge_ota.ui.screen.HomeScreen


fun NavGraphBuilder.mainNavigation(navController: NavController) {
    composable(Screen.Home.route) {
        HomeScreen(modifier = Modifier.fillMaxSize())
    }
}

sealed class Screen(val route: String) {
    data object Home : Screen("home")
}