package com.example.retrofit2example.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface FakestoreServices {

    @GET("/products")
    suspend fun getAllProducts(): Response<ProductsModel>
}