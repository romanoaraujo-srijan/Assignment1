package com.example.assignment.ui.theme
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.ColumnScope
import com.example.assignment.ApiInterface
import com.example.assignment.data.Data
import com.example.assignment.view.Product
import com.google.gson.Gson
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


//lateinit var userCheck: Data
//
//fun extractJsonData() {
//    val gson = Gson()
//    userCheck = gson.fromJson(json, Data::class.java)
//    // userCheck = jsonObj.fromJson(json, Data::class.java)
//    Log.d("Romano", "user check: ${userCheck.userNameData}")
//}

//fun validateUser(userName: String, passwordDa: String): Boolean {
//    extractJsonData()
//    val one = userCheck.userNameData
//    val two = userCheck.passwordData
//    Log.d("Romano", "validate: $one  and $two ")
//    return (userName == userCheck.userNameData && passwordDa == userCheck.passwordData)
//}


fun readJsonData(context: Context): String {
    val json = context.assets.open("Json_user_data.json").bufferedReader().use {
        it.readText()
    }

    return json

    //read data from api call
//    data = context.assets.open("Json_data.json").bufferedReader().use {
//        it.readText()
//    }
}

var productList: List<Product>? = null

fun getApiData() {
    //var productList: List<Product>? = null
    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://fakestoreapi.com/")
        .build()
        .create(ApiInterface::class.java)

    val retrofitData = retrofitBuilder.getData()

    retrofitData.enqueue(object : Callback<List<Product>?> {
        override fun onResponse(call: Call<List<Product>?>, response: Response<List<Product>?>){
            Log.d("RetFt", "onResponse: ${response.body().toString()}")
            if(response.body() != null) productList = response.body()!!
            Log.d("RetFt", "onResponse: size = ${productList?.size}")
        }
        override fun onFailure(call: Call<List<Product>?>, t: Throwable) {
            Log.d("RetFt", "onFailure: $t")
        }
    })
}