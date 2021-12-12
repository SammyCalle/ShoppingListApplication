package com.example.shoppinglistapplication.data

import com.example.shoppinglistapplication.model.response.ProductsResponseItem
import com.example.shoppinglistapplication.model.response.Rating
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class RepositoryTest {
    private val rating1 = Rating(count = 120 , rate = 4.3)
    private val product1 = ProductsResponseItem(category = "category",description = "description",
    id = 1 , image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
    price = 10.20 , rating = rating1 , title = "title")
    private val rating2 = Rating(count = 120 , rate = 4.3)
    private val product2 = ProductsResponseItem(category = "category",description = "description",
        id = 2 , image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
        price = 10.20 , rating = rating2 , title = "title")
    private val rating3 = Rating(count = 120 , rate = 4.3)
    private val product3 = ProductsResponseItem(category = "category",description = "description",
        id = 3 , image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
        price = 10.20 , rating = rating3 , title = "title")
    private val remoteTask = listOf(product1,product2,product3).sortedBy { it.id }

    private lateinit var repository: Repository

    @Before
    fun createRepository (){
        repository = Repository(Dispatchers.Unconfined)
    }

    @Test
    fun getItemsFromRemoteDataSource() = runBlockingTest{

    }

}