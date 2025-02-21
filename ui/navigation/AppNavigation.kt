package com.example.indica.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

object AppDestinations {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val DASHBOARD = "dashboard"
    const val INDICATION = "indication"
    const val INDICATION_HISTORY = "indication_history"
    const val REWARDS = "rewards"
    const val PROFILE = "profile"
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String = AppDestinations.SPLASH
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(AppDestinations.SPLASH) {
            SplashScreen(onNavigateToLogin = {
                navController.navigate(AppDestinations.LOGIN) {
                    popUpTo(AppDestinations.SPLASH) { inclusive = true }
                }
            })
        }
        
        composable(AppDestinations.LOGIN) {
            LoginScreen(onNavigateToDashboard = {
                navController.navigate(AppDestinations.DASHBOARD) {
                    popUpTo(AppDestinations.LOGIN) { inclusive = true }
                }
            })
        }
        
        composable(AppDestinations.DASHBOARD) {
            DashboardScreen(
                onNavigateToIndication = { navController.navigate(AppDestinations.INDICATION) },
                onNavigateToHistory = { navController.navigate(AppDestinations.INDICATION_HISTORY) },
                onNavigateToRewards = { navController.navigate(AppDestinations.REWARDS) },
                onNavigateToProfile = { navController.navigate(AppDestinations.PROFILE) }
            )
        }
        
        composable(AppDestinations.INDICATION) {
            IndicationScreen(onBackClick = { navController.popBackStack() })
        }
        
        composable(AppDestinations.INDICATION_HISTORY) {
            IndicationHistoryScreen(onBackClick = { navController.popBackStack() })
        }
        
        composable(AppDestinations.REWARDS) {
            RewardsScreen(onBackClick = { navController.popBackStack() })
        }
        
        composable(AppDestinations.PROFILE) {
            ProfileScreen(
                onBackClick = { navController.popBackStack() },
                onLogout = {
                    navController.navigate(AppDestinations.LOGIN) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}