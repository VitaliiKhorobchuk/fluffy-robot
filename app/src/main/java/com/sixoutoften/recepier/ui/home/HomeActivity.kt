package com.sixoutoften.recepier.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sixoutoften.recepier.R
import com.sixoutoften.recepier.ui.home.documents.DocumentsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DocumentsFragment())
                .commitNow()
        }
    }
}