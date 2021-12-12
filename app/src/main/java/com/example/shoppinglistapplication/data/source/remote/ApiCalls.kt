package com.example.shoppinglistapplication.data.source.remote

import com.example.shoppinglistapplication.model.response.ProductsResponse
import com.example.shoppinglistapplication.model.response.ProductsResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiCalls {
    @GET("products")
    suspend fun getAllProducts(): Response<List<ProductsResponseItem>>
}