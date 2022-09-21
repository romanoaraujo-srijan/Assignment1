package com.example.assignment.data

import android.content.Context
import android.util.Log

import com.google.gson.Gson

private const val USER_VERIFICATION = "USER_VERIFICATION"
private const val USER_NAME_KEY = "USER_NAME_KEY"
private const val PASSWORD_KEY = "PASSWORD_KEY"

fun saveData(context: Context,userName: String,password: String) {
    val sharedPreferences = context.getSharedPreferences(USER_VERIFICATION,Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.apply {
        putString(USER_NAME_KEY,userName)
        putString(PASSWORD_KEY,password)
        apply()
    }
}

//If shared pref does not exist, userName and password will contain empty string
fun loadData(context: Context): Data {

    val user = Data("","")

    val sharedPreferences = context.getSharedPreferences(USER_VERIFICATION,Context.MODE_PRIVATE)
    user.userNameData = sharedPreferences.getString(USER_NAME_KEY,"").toString()
    user.passwordData = sharedPreferences.getString(PASSWORD_KEY,"").toString()

    return user
}


//lateinit var userCheck: Data
//
//fun extractJsonData(context: Context) {
//    val gson = Gson()
//    userCheck = gson.fromJson(json, Data::class.java)
//    // userCheck = jsonObj.fromJson(json, Data::class.java)
//    Log.d("Romano", "user check: ${userCheck.userNameData}")
//    //return userCheck
//}
//
//fun validateUser(userName: String, passwordDa: String): Boolean {
//    extractJsonData()
//    val one = userCheck.userNameData
//    val two = userCheck.passwordData
//    Log.d("Romano", "validate: $one  and $two ")
//    return (userName == userCheck.userNameData && passwordDa == userCheck.passwordData)
//}

//fun readJsonData(context: Context): String {
//    val json = context.assets.open("Json_user_data.json").bufferedReader().use {
//        it.readText()
//    }
//
//    //read data from api call
////    data = context.assets.open("Json_data.json").bufferedReader().use {
////        it.readText()
////    }
//    return json
//}
//fun readJsonData(context: Context): String {
//    val json = context.assets.open("Json_user_data.json").bufferedReader().use {
//        it.readText()
//    }
//
//    return json
//
//    //read data from api call
////    data = context.assets.open("Json_data.json").bufferedReader().use {
////        it.readText()
////    }
