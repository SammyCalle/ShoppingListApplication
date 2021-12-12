package com.example.shoppinglistapplication.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.shoppinglistapplication.data.local.ToDoDatabase
import com.example.shoppinglistapplication.data.local.getDatabase
import com.example.shoppinglistapplication.data.source.remote.Network
import com.example.shoppinglistapplication.model.domain.cart.CartProductsItem
import com.example.shoppinglistapplication.model.response.ProductsResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class Repository(private val database: ToDoDatabase,private val ioDispatcher
: CoroutineDispatcher = Dispatchers.IO) : IRepository {

    companion object{
        @Volatile
        private var INSTANCE : Repository? = null
        fun getRepository(app: Application): Repository{
            return INSTANCE ?: synchronized(this){
                Repository(database = getDatabase(app)).also {
                    INSTANCE = it
                }
            }
        }
    }

    override val cartProducts : LiveData<List<CartProductsItem>> =
        database.itemsDao().getCartProducts()

    override suspend fun addProductDatabase(cartProductsItem: CartProductsItem) {
        withContext(ioDispatcher){
            database.itemsDao().insertCartProduct(cartProductsItem)
        }
    }

    override suspend fun upDateProductDatabase(addquatinty : Int , id : Int) {
        withContext(ioDispatcher){
            database.itemsDao().updateQuantity(addquatinty, id)
        }
    }

    override suspend fun deleteProductDataBase(id : Int) {
       withContext(ioDispatcher){
           database.itemsDao().deleteProduct(id)
       }
    }


    override suspend fun getAllProducts() = Network.service.getAllProducts()

}