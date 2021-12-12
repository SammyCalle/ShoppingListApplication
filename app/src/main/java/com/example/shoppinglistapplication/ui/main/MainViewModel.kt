package com.example.shoppinglistapplication.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistapplication.data.IRepository
import com.example.shoppinglistapplication.model.domain.ProductsItem
import com.example.shoppinglistapplication.model.mapper.ProductsMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel constructor(private val repository: IRepository) : ViewModel() {

    val listForRecycler = MutableLiveData<List<ProductsItem>>()
    fun getAllProducts(){
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                val response = repository.getAllProducts()
                if (response.isSuccessful){
                    response.body()?.apply {
                        listForRecycler.value = ProductsMapper.mapProductsItem(this)
                    }
                }else{
                    if (response.code() == 400){
                        response.errorBody()
                        Log.e("ErrorRepo",response.errorBody().toString())
                    }
                }
            }
        }
    }

    fun addProductoDataBase(productsItem: ProductsItem, quantityadd : Int){
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                repository.addProductDatabase(ProductsMapper.mapProductsToDataBase(productsItem,quantityadd))
            }
        }
    }

}