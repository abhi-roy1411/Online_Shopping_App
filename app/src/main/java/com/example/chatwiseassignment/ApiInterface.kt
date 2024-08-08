package com.example.chatwiseassignment


import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/products")
    fun getData(): Call<MyData>
}