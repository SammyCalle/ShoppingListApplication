package com.example.shoppinglistapplication.model.mapper

import com.example.shoppinglistapplication.model.domain.ProductsItem
import com.example.shoppinglistapplication.model.domain.cart.CartProductsItem
import com.example.shoppinglistapplication.model.response.ProductsResponseItem
import com.example.shoppinglistapplication.model.response.Rating

object ProductsMapper {
     fun mapProductsItem(productItemsResponse : List<ProductsResponseItem>) : List<ProductsItem>{
         val itemList = mutableListOf<ProductsItem>()
         productItemsResponse.forEach {
             itemList.add(
                 ProductsItem(category = it.category,
                     description = it.description,
                     id = it.id,
                     image = it.image,
                     price = it.price,
                     rating = mapRating(it.rating),
                     title = it.title)
             )
         }
         return itemList
    }

    private fun mapRating(ratingResponse: Rating) : com.example.shoppinglistapplication.model.domain.Rating{
        return com.example.shoppinglistapplication.model.domain.Rating(count = ratingResponse.count,
        rate = ratingResponse.rate.toFloat())
    }

    fun mapProductsToDataBase(productsItem: ProductsItem, quantity : Int) : CartProductsItem{
        return CartProductsItem(category = productsItem.category,
        description = productsItem.description, id = productsItem.id,
        quantity = quantity, image = productsItem.image,
        price = productsItem.price , title = productsItem.title)
    }

}