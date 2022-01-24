package com.sixoutoften.recepier.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sixoutoften.recepier.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bnv = findViewById<BottomNavigationView>(R.id.bnvHome)
        bnv.setupWithNavController(Navigation.findNavController(this, R.id.fcvHome))
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, DocumentListFragment())
//                .commitNow()
//        }
    }
}