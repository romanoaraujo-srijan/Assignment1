package com.example.assignment

import android.graphics.Shader
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.data.dataOfUsers
import com.example.assignment.data.loadData
import com.example.assignment.ui.theme.AssignmentTheme
import com.example.assignment.ui.theme.ProductScreen
import com.example.assignment.ui.theme.Result
import com.example.assignment.ui.theme.loginPage
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    var context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // loginPage()
            startScreen(text = "Romano")
        }

        loadData(this)
        thread {
            Thread.sleep(2000)

            if (dataOfUsers.userNameData.isEmpty() && dataOfUsers.passwordData.isEmpty()) {
                context.setContent {
                    loginPage(this) {
                        context.setContent {
                            ProductScreen()
                        }
                    }
                }
            } else {
                context.setContent {
                    ProductScreen()
                }
            }

        }

    }
}

//@Preview(showBackground = true)
@Composable
fun startScreen(text: String = "Romano") {
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
}
