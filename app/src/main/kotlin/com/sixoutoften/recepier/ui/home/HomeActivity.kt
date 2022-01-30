package com.sixoutoften.recepier.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sixoutoften.recepier.MainNavigationDirections
import com.sixoutoften.recepier.R
import com.sixoutoften.recepier.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.fcvHome)
        binding.bnvHome.setupWithNavController(navController)

        binding.fabNewDocument.let { fab ->
            fab.setOnClickListener {
                navController.navigate(MainNavigationDirections.navigateToDocumentDetail())
            }
            // TODO: connect to list scroll or empty state
//            if (fab.isExtended) {
//                fab.shrink()
//            } else {
//                fab.extend()
//            }
        }
    }
}