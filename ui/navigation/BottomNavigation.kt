package com.example.indica.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

enum class BottomNavItem(
    val route: String,
    val titleResId: Int,
    val icon: Int
) {
    DASHBOARD(AppDestinations.DASHBOARD, R.string.dashboard, R.drawable.ic_home),
    INDICATION(AppDestinations.INDICATION, R.string.indication, R.drawable.ic_add),
    HISTORY(AppDestinations.INDICATION_HISTORY, R.string.history, R.drawable.ic_history),
    REWARDS(AppDestinations.REWARDS, R.string.rewards, R.drawable.ic_rewards),
    PROFILE(AppDestinations.PROFILE, R.string.profile, R.drawable.ic_person)
}

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val items = BottomNavItem.values()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(painter = painterResource(id = item.icon), contentDescription = null) },
                label = { Text(text = stringResource(id = item.titleResId)) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}