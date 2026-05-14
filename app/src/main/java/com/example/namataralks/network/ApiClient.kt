package com.example.namataralks.network

import com.example.namataralks.model.AtractionModel
import com.example.namataralks.model.CategoryModel
import com.example.namataralks.model.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiClient {

    @POST("api/auth/sign-in")
    fun loginUser(@Body request: UserModel.LoginRequest): Call<UserModel.LoginResponse>

    @POST("api/auth/sign-up")
    fun registryUser(@Body request: UserModel.RegisterRequest): Call<UserModel.RegisterResponse>

    @GET("api/categories")
    fun categoryList(@Header("Authorization") token: String): Call<CategoryModel.CategoryResponse>

    @GET("api/tourismattractions")
    fun attrTourism(): Call<AtractionModel.attrRaesp>
}