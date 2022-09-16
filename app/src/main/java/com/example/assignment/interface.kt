package com.example.assignment

import com.example.assignment.ui.theme.Product
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/products")
    fun getData(): Call<List<Product>>
}