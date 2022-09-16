package com.example.assignment

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.assignment.data.loadData
import com.example.assignment.ui.theme.Product
import com.example.assignment.ui.theme.data
import com.example.assignment.ui.theme.getApiData
import com.example.assignment.ui.theme.readJsonData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            readJsonData(this)
            loadData(this)
            getApiData()
            navigation(rememberNavController(), context = this)
        }

    }
}
