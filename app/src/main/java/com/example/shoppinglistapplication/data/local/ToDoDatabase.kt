package com.example.shoppinglistapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglistapplication.model.domain.cart.CartProductsItem

@Database(entities = [CartProductsItem::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun itemsDao(): ItemsDao
}
private lateinit var INSTANCE: ToDoDatabase

fun getDatabase(context: Context): ToDoDatabase {
    synchronized(ToDoDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                ToDoDatabase::class.java,
                "products").build()
        }
    }
    return INSTANCE
}