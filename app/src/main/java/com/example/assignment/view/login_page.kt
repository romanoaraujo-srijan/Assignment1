package com.example.assignment.ui.theme

import LoginViewModel
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun loginPage(context: Context, navController: NavHostController, loginViewModel: LoginViewModel) {

    Column(verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //User Name
        Row(modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(modifier = Modifier.padding(10.dp)){
                Text(text = "User Name", color = Color.Black, textAlign = TextAlign.Center)
            }
            Column(modifier = Modifier.padding(10.dp)){
                TextField(
                    value = loginViewModel.userNameState.value,
                    onValueChange = {
                        loginViewModel.onUserNameValueChange(it)
                    },
                    label = { Text(text = "Enter user name") }
                )
            }
        }

        Row(modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(modifier = Modifier.padding(10.dp)){
                Text(text = "Password", color = Color.Black, textAlign = TextAlign.Center)
            }
            Column(modifier = Modifier.padding(10.dp)){
                TextField(
                    value = loginViewModel.password.value,
                    onValueChange = {
                        loginViewModel.onPasswordValueChange(it)
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    label = { Text(text = "Enter password") }
                )
            }
        }

        Button(onClick = { loginViewModel.onClickButton(context,navController) }
        ) { Text(text = "LOGIN") }

        if(loginViewModel.openDialog.value){
            AlertDialog(
                onDismissRequest = {
                    loginViewModel.onDialogResponseChange(false)
                },
                title = {
                    Text(text = "Hello ${loginViewModel.userNameState.value}")
                },
                text = {
                    Text("Incorrect username or password")
                },
                confirmButton = {
                    Button(onClick = {
                        loginViewModel.onDialogResponseChange(false)
                    }) { Text("Ok") }
                },
            )
        }
    }


//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        val openDialog = remember { mutableStateOf(false) }
//
//        displayLogin(list = userNam, type = "login")
//        displayLogin(list = passwordList, type = "password")
//
//        Button(onClick = {
//            val status = validateUser(dataOfUsers.userNameData, dataOfUsers.passwordData)
//            if (status) {
//                Log.d("Romano", "loginPage: $status")
//                saveData(context, dataOfUsers.userNameData, dataOfUsers.passwordData)
//                navController.navigate(route = Screens.welcome_screen.route) {
//                    popUpTo(Screens.login_page.route) {
//                        inclusive = true
//                    }
//                }
//            } else {
//                openDialog.value = true
//            }
//
//        }) {
//            Text(text = "LOGIN")
//        }
//        if (openDialog.value) {
//            AlertDialog(
//                onDismissRequest = {
//                    openDialog.value = false
//                },
//                title = {
//                    Text(text = "Hello ${dataOfUsers.userNameData}")
//                },
//                text = {
//                    Text("Incorrect username or password")
//                },
//                confirmButton = {
//                    Button(onClick = {
//                        openDialog.value = false
//                    }) { Text("Ok") }
//                },
//            )
//        }
//
//    }
}

//@Composable
//fun displayLogin(list: List<String>, type: String) {
//    Row(
//        modifier = Modifier,
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center
//    ) {
//        Column(modifier = Modifier.padding(10.dp)) {
//            Text(text = list[0])
//        }
//        Column(modifier = Modifier.padding(10.dp)) {
//            val inputValue = remember { mutableStateOf("") }
//            TextField(
//                value = inputValue.value,
//                onValueChange = { inputValue.value = it },
//                label = { Text(text = list[1]) }
//            )
//            if (type == "login") {
//                dataOfUsers.userNameData = inputValue.value
//            } else {
//                dataOfUsers.passwordData = inputValue.value
//            }
//
//        }
//    }
//}
