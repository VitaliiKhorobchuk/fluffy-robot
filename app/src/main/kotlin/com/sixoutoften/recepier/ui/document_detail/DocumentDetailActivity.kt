package com.sixoutoften.recepier.ui.document_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.sixoutoften.recepier.R
import com.sixoutoften.recepier.databinding.ActivityDocumentDetailBinding
import com.sixoutoften.recepier.util.RLogger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DocumentDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDocumentDetailBinding

    @Inject lateinit var logger: RLogger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDocumentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureToolbar()
    }

    private fun configureToolbar() {
        binding.tbDocumentDetail.setNavigationOnClickListener {
            if (!findNavController(R.id.fcvDocumentDetail).popBackStack()) {
                finish()
            }
        }
    }
}
