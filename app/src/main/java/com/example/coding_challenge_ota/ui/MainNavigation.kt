package com.example.coding_challenge_ota.ui

import androidx.navigation.NavHostController

object MainDestination {
    const val HOME = "home"
    const val ACCOUNT = "account"
    const val JOURNEY = "journey"
}

class MainNavigation(
    private val navController: NavHostController
) {

    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }
}