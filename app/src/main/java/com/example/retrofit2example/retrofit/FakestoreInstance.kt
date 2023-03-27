package com.example.retrofit2example.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FakestoreInstance {
    // Advised to use singleton instance to avoid memory leaks, save network time
    companion object{
        val BASE_URL = "https://fakestoreapi.com/"

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}