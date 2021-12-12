package com.example.shoppinglistapplication.data

import androidx.lifecycle.LiveData
import com.example.shoppinglistapplication.model.domain.cart.CartProductsItem
import com.example.shoppinglistapplication.model.response.ProductsResponse
import com.example.shoppinglistapplication.model.response.ProductsResponseItem
import retrofit2.Response

interface IRepository {
    val cartProducts : LiveData<List<CartProductsItem>>
    suspend fun addProductDatabase(cardProductsItem: CartProductsItem)
    suspend fun upDateProductDatabase(addquatinty : Int , id : Int)
    suspend fun deleteProductDataBase(id : Int)
    suspend fun getAllProducts(): Response<List<ProductsResponseItem>>
}