package com.project.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.application.navigation.Route
import com.project.design_system.theme.ApplicationTheme
import com.project.home.presentation.HomeScreen
import com.project.login.presentation.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Route.LOGIN) {
                    composable(Route.LOGIN) {
                        LoginScreen(
                            onLoginSuccess = {
                                navController.navigate(Route.HOME)
                            }
                        )
                    }
                    composable(Route.HOME) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}