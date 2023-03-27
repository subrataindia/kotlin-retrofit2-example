package com.example.retrofit2example.retrofit

data class ProductModel(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingModel,
    val title: String
)