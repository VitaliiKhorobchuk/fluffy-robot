package com.sixoutoften.recepier.ui.document_detail

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sixoutoften.recepier.databinding.FragmentDocumentDetailBinding
import com.sixoutoften.recepier.util.RLogger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DocumentDetailFragment : Fragment() {

    private lateinit var binding: FragmentDocumentDetailBinding
    private val viewModel: DocumentDetailViewModel by viewModels()

    @Inject
    lateinit var logger: RLogger

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDocumentDetailBinding.inflate(inflater)

        configureUi()
        return binding.root
    }

    private fun configureUi() {
        binding.btnSave.setOnClickListener {

        }
        binding.mcvMainImage.setOnClickListener {
            openSomeActivityForResult()
        }

    }


    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                result.data?.let { intent ->
                    viewModel.saveObtainedFiles(intent)
                }
            }
        }

    private fun openSomeActivityForResult() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"

        // Only pick openable and local files. Theoretically we could pull files from google drive
        // or other applications that have networked files, but that's unnecessary for this example.

        intent.addCategory(Intent.CATEGORY_OPENABLE)

        intent.putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/*", "application/pdf", "application/msword", "text/plain"))
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true)
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        resultLauncher.launch(intent)
    }


}