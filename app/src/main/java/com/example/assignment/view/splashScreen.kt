package com.example.assignment

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment.data.dataOfUsers
import com.example.assignment.data.loadData
import com.example.assignment.ui.theme.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay


@Composable
fun startScreen(navController: NavController, context: Context, text: String = "Romano") {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text, color = Color.Black, fontSize = 80.sp, fontFamily = FontFamily.Cursive,
            style = TextStyle(
                shadow = Shadow(
                    Color.White, offset = Offset(20.0f, 6.0f), blurRadius = 15.0f
                )
            )
        )
    }

    LaunchedEffect(key1 = true) {
        Log.d("romano", "startScreen: $data")

        delay(1000)

        if (dataOfUsers.userNameData.isEmpty() && dataOfUsers.passwordData.isEmpty()) {
            navController.navigate(route = Screens.login_page.route) {
                popUpTo(Screens.Start_Screen.route) {
                    inclusive = true
                }
            }
        } else {
            navController.navigate(route = Screens.welcome_screen.route) {
                popUpTo(Screens.Start_Screen.route) {
                    inclusive = true
                }
            }
        }
    }
}
