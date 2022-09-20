package com.example.assignment

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.assignment.ui.theme.loginPage
import com.example.assignment.view.productScreen

@Composable
fun navigation(navController: NavHostController, context: Context) {
    NavHost(navController = navController, startDestination = Screens.Start_Screen.route) {
        composable(
            route = Screens.Start_Screen.route
        ) {
            startScreen(navController, context)
        }
        composable(
            route = Screens.login_page.route
        ) {
            loginPage(context, navController)
        }
        composable(
            route = Screens.welcome_screen.route
        ) {
            productScreen()

        }
    }
}