package com.example.shoppinglistapplication.data.source.remote

import com.example.shoppinglistapplication.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: ApiCalls = retrofit.create(ApiCalls::class.java)
}