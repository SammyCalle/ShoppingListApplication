package com.example.shoppinglistapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoppinglistapplication.model.domain.cart.CartProductsItem

@Dao
interface ItemsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCartProduct(product : CartProductsItem)

    @Query("select * from cartProduct")
    fun getCartProducts() : LiveData<List<CartProductsItem>>

    @Query("UPDATE cartProduct SET quantity =:addquantity WHERE id =:forid")
    fun updateQuantity(addquantity : Int, forid:Int)

    @Query("DELETE FROM cartProduct WHERE id = :forId")
    fun deleteProduct(forId : Int)
}
