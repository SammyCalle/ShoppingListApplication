package com.example.shoppinglistapplication.model.domain.cart

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cartProduct")
data class CartProductsItem(
    val category: String,
    val description: String,
    @PrimaryKey
    val id: Int,
    val quantity : Int,
    val image: String,
    val price: Double,
    val title: String
)