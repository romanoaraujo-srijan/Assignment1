package com.example.assignment.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.assignment.data.dataOfUsers
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class Product(var productName: String, var imageUrl: String)

var index = -1
lateinit var productList: Array<Product>
fun convertToArray(){
    var gson = Gson()
    val typeToken = object : TypeToken<Array<Product>>(){}.type
    productList = gson.fromJson(data, typeToken)

//    for (value in productList){
//        Log.d("Romano", "convertToArray: ${value.productName}")
//    }
}

@Composable
fun Result(){
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Your Input")
            Text(text = dataOfUsers.userNameData)
        }
    }
}



//Home Screen
@Composable
fun ProductScreen(){
    val numberOfRows = 2

    convertToArray() //Convert JSON to Kotlin Array

    //Main Column
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        for (i in 1..numberOfRows) DrawHomeRows()
    }
}

@Composable
fun DrawHomeRows(){
    Row {
        Box(modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(10.dp)) {
            DrawHomeEachColumn()
        }
        Box(modifier = Modifier.padding(10.dp)) {
            DrawHomeEachColumn()
        }
    }
}

@Composable //Generates Each individual card in of each column in a row
fun DrawHomeEachColumn() {
    index++
    //Log.d("romi", "DrawHomeEachColumn:  ${R.}")
    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp)) {
        Column(
            modifier = Modifier.height(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(

                painter = painterResource(id = productList[index].imageUrl.toInt()),

                  //painter =  painterResource(id = 2130968577),
               // painter = painterResource(id = productList[index].imageUrl),
                contentDescription = "",
                contentScale = ContentScale.Fit)
            Text(text = productList[index].productName)
        }
    }
}
