package com.sixoutoften.recepier.ui.home.document_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.sixoutoften.recepier.databinding.ActivityDocumentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DocumentDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDocumentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDocumentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
