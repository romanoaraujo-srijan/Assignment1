package com.example.assignment



sealed class Screens(val route: String) {
    object Start_Screen: Screens(route = "startScreen")
    object login_page: Screens(route = "loginPage")
    object welcome_screen: Screens(route = "ProductScreen")
}
