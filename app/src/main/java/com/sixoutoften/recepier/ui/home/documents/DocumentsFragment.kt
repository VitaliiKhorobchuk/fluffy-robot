package com.sixoutoften.recepier.ui.home.documents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sixoutoften.recepier.R
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DocumentsFragment : Fragment() {

    private val viewModel: DocumentsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_documents, container, false)
    }

    override fun onStart() {
        super.onStart()
        viewModel.initTest()
    }
}