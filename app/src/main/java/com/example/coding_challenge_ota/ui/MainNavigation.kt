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

    val navigateToHome: () -> Unit = {
        navController.navigate(MainDestination.HOME) {
            restoreState = true
        }
    }

    val navigateToAccount: () -> Unit = {
        navController.navigate(MainDestination.ACCOUNT) {
            restoreState = true
        }
    }

    val navigateToJourney: () -> Unit = {
        navController.navigate(MainDestination.JOURNEY) {
            restoreState = true
        }
    }
}

