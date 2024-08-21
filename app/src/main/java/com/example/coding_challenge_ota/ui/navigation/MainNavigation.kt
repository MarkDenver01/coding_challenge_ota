package com.example.coding_challenge_ota.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coding_challenge_ota.utils.Constants.ACCOUNT
import com.example.coding_challenge_ota.utils.Constants.HOME
import com.example.coding_challenge_ota.utils.Constants.JOURNEY

sealed class Screen(val route: String) {
    data object Home : Screen(HOME)
    data object Journey : Screen(JOURNEY)
    data object Account : Screen(ACCOUNT)
}

fun NavGraphBuilder.mainNavigation(navController: NavController) {
    composable(Screen.Home.route) {

    }
}