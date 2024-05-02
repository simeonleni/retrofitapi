package com.example.retrofitapi

import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("comments")
    fun getComments(): Call<List<Comments>>
}