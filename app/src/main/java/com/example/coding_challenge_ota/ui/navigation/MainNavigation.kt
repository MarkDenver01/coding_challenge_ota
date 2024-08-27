package com.example.coding_challenge_ota.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coding_challenge_ota.ui.screen.HomeScreen
import com.example.coding_challenge_ota.utils.Constants.ACCOUNT
import com.example.coding_challenge_ota.utils.Constants.HOME
import com.example.coding_challenge_ota.utils.Constants.JOURNEY


fun NavGraphBuilder.mainNavigation(navController: NavController) {
    composable(Screen.Home.route) {
        HomeScreen(modifier = Modifier.fillMaxWidth())
    }
}

sealed class Screen(val route: String) {
    data object Home : Screen("home")
}