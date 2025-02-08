package com.google.ncfsegurosindico.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.LocalOnBackPressedDispatcherOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.ncfsegurosindico.screens.LoginScreen
import com.google.ncfsegurosindico.screens.SplashScreen
import kotlinx.coroutines.delay
import androidx.activity.OnBackPressedCallback
import com.google.ncfsegurosindico.screens.DashboardScreen

/**
 * Controlador principal de navegação do aplicativo
 * Gerencia todas as rotas e transições entre telas
 */
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    // Tratamento do botão voltar
    val backCallback = remember {
        OnBackPressedCallback {
            when (navController.currentDestination?.route) {
                NavigationRoutes.LOGIN_SCREEN -> {
                    // No login, fecha o app
                    navController.popBackStack()
                }
                NavigationRoutes.SPLASH_SCREEN -> {
                    // Na splash, não faz nada
                    return@OnBackPressedCallback
                }
                else -> {
                    // Em outras telas, volta para a anterior
                    navController.navigateUp()
                }
            }
        }
    }

    // Registra o callback do botão voltar
    DisposableEffect(backCallback) {
        val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
        dispatcher?.addCallback(backCallback)
        onDispose {
            backCallback.remove()
        }
    }

    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.SPLASH_SCREEN
    ) {
        composable(NavigationRoutes.SPLASH_SCREEN) {
            SplashScreen()
            LaunchedEffect(true) {
                delay(3000)
                navController.navigate(NavigationRoutes.LOGIN_SCREEN) {
                    popUpTo(NavigationRoutes.SPLASH_SCREEN) { inclusive = true }
                }
            }
        }
        
        composable(NavigationRoutes.LOGIN_SCREEN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(NavigationRoutes.DASHBOARD_SCREEN) {
                        popUpTo(NavigationRoutes.LOGIN_SCREEN) { inclusive = true }
                    }
                },
                onRegisterClick = {
                    navController.navigate(NavigationRoutes.REGISTER_SCREEN)
                }
            )
        }
        
        composable(NavigationRoutes.DASHBOARD_SCREEN) {
            DashboardScreen(navController)
        }
    }
}

/**
 * Gerencia a navegação após a SplashScreen
 */
@Composable
private fun HandleSplashNavigation(navController: NavHostController) {
    LaunchedEffect(true) {
        try {
            delay(3000) // Delay de 3 segundos
            navController.navigate(NavigationRoutes.LOGIN_SCREEN) {
                popUpTo(NavigationRoutes.SPLASH_SCREEN) { inclusive = true }
            }
        } catch (e: Exception) {
            // TODO: Implementar tratamento de erro adequado
            e.printStackTrace()
        }
    }
} 