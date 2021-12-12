package com.example.shoppinglistapplication.ui.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistapplication.data.IRepository
import com.example.shoppinglistapplication.model.domain.ProductsItem
import com.example.shoppinglistapplication.model.domain.cart.CartProductsItem
import com.example.shoppinglistapplication.model.mapper.ProductsMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CartViewModel(private val repository: IRepository) : ViewModel() {

    val listForRecycler = MutableLiveData<List<CartProductsItem>>()
    fun getAllProducts(){
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                listForRecycler.value =repository.cartProductdSelection().value
            }
        }
    }

    fun deleteProduct(productId : Int){
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                repository.deleteProductDataBase(productId)
            }
        }
    }

    fun updateProdcut(quantityProduct : Int , productId: Int){
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                repository.upDateProductDatabase(quantityProduct,productId)
            }
        }
    }

}