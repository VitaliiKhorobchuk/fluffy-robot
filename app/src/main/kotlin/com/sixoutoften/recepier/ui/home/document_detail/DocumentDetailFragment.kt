package com.sixoutoften.recepier.ui.home.document_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sixoutoften.recepier.databinding.FragmentDocumentDetailBinding
import com.sixoutoften.recepier.util.RLogger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DocumentDetailFragment : Fragment() {

    private lateinit var binding: FragmentDocumentDetailBinding

    @Inject lateinit var logger: RLogger

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDocumentDetailBinding.inflate(inflater)

        logger.d("test")
        return binding.root
    }
}