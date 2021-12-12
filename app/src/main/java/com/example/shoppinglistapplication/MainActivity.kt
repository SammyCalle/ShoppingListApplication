package com.example.shoppinglistapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.shoppinglistapplication.ui.main.MainFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navigationController = findNavController(R.id.fragmentContainerView)
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.mainFragment,R.id.cartFragment))
//        setupActionBarWithNavController(navigationController,appBarConfiguration)
        bottomNavigation.setupWithNavController(navHostFragment!!.findNavController())
    }
}