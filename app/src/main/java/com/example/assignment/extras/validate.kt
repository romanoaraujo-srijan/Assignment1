package com.example.assignment.ui.theme
import android.util.Log
import com.example.assignment.data.Data
import com.google.gson.Gson


lateinit var userCheck: Data

fun extractJsonData() {
    val gson = Gson()
    userCheck = gson.fromJson(json, Data::class.java)
   // userCheck = jsonObj.fromJson(json, Data::class.java)
    Log.d("Romano", "user check: ${userCheck.userNameData}")
}

fun validateUser(userName: String, passwordDa: String): Boolean {
    val one = userCheck.userNameData
    val two = userCheck.passwordData
    Log.d("Romano", "validate: $one  and $two ")
    return (userName == userCheck.userNameData && passwordDa == userCheck.passwordData)
}
