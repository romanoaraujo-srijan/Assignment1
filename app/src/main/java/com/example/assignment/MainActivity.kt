package com.example.assignment

import LoginViewModel
import SplashScreenViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private val splashScreenViewModel: SplashScreenViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navigation(
                navController = rememberNavController(),
                context = this,
                loginViewModel =loginViewModel ,
                splashScreenViewModel = splashScreenViewModel
            )
//            navigation(
//                rememberNavController().also { navController = it },
//                var context : kotlin . Any ? = this,
//            val loginViewModel: Any = loginViewModel,
//            val splashScreenViewModel: Any = splashScreenViewModel)
        }

//        private val loginViewModel: LoginViewModel by viewModels()
//        private val splashScreenViewModel: SplashScreenViewModel by viewModels()
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//
//            //Call Navigation Controller which shows Splash() as first screen
//            setContent{
//                Navigation(
//                    navController = rememberNavController(),
//                    context = this,
//                    loginViewModel = loginViewModel,
//                    splashScreenViewModel = splashScreenViewModel
//                )
//            }
//        }

    }
}