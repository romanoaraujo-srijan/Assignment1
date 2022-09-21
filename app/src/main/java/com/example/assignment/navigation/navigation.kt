package com.example.assignment

import LoginViewModel
import SplashScreenViewModel
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.assignment.ui.theme.loginPage
import com.example.assignment.view.productScreen



//
//sealed class Screens(val route: String) {
//    object Start_Screen: Screens(route = "startScreen")
//    object login_page: Screens(route = "loginPage")
//    object welcome_screen: Screens(route = "ProductScreen")
//}


@Composable
fun navigation(navController: NavHostController,context: Context, loginViewModel: LoginViewModel,splashScreenViewModel: SplashScreenViewModel) {
    NavHost(navController = navController, startDestination = Screens.Start_Screen.route) {
        composable(
            route = Screens.Start_Screen.route
        ) {
            startScreen(context,navController,splashScreenViewModel)
           // context,navController,splashScreenViewModel
        }
        composable(
            route = Screens.login_page.route
        ) {
            loginPage(context = context, navController = navController,loginViewModel = loginViewModel)
        }
        composable(
            route = Screens.welcome_screen.route
        ) {
            productScreen()
        }
    }
}