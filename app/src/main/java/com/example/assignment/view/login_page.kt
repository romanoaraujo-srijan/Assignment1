package com.example.assignment.ui.theme

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.assignment.Screens
import com.example.assignment.data.dataOfUsers
import com.example.assignment.data.saveData

@Composable
fun loginPage(context: Context, navController: NavController) {
    val userNam = mutableListOf("User Name", "Enter User Name")
    val passwordList = mutableListOf("password", "Enter password")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val openDialog = remember { mutableStateOf(false) }

        displayLogin(list = userNam, type = "login")
        displayLogin(list = passwordList, type = "password")

        Button(onClick = {
            val status = validateUser(dataOfUsers.userNameData, dataOfUsers.passwordData)
            if (status) {
                Log.d("Romano", "loginPage: $status")
                saveData(context, dataOfUsers.userNameData, dataOfUsers.passwordData)
                navController.navigate(route = Screens.welcome_screen.route) {
                    popUpTo(Screens.login_page.route) {
                        inclusive = true
                    }
                }
            } else {
                openDialog.value = true
            }

        }) {
            Text(text = "LOGIN")
        }
        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },
                title = {
                    Text(text = "Hello ${dataOfUsers.userNameData}")
                },
                text = {
                    Text("Incorrect username or password")
                },
                confirmButton = {
                    Button(onClick = {
                        openDialog.value = false
                    }) { Text("Ok") }
                },
            )
        }

    }
}

@Composable
fun displayLogin(list: List<String>, type: String) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = list[0])
        }
        Column(modifier = Modifier.padding(10.dp)) {
            val inputValue = remember { mutableStateOf("") }
            TextField(
                value = inputValue.value,
                onValueChange = { inputValue.value = it },
                label = { Text(text = list[1]) }
            )
            if (type == "login") {
                dataOfUsers.userNameData = inputValue.value
            } else {
                dataOfUsers.passwordData = inputValue.value
            }

        }
    }
}
