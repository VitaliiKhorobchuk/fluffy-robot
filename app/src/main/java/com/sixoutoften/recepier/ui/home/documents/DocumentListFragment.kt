package com.sixoutoften.recepier.ui.home.documents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sixoutoften.recepier.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class DocumentListFragment : Fragment() {

    private val viewModel: DocumentListViewModel by viewModels()

    private lateinit var tvMessage: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_documents, container, false)
        tvMessage = view.findViewById(R.id.message)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initTest()
        subscribeAll()
    }

    private fun subscribeAll() {
        lifecycleScope.launchWhenCreated {
            viewModel.stateFlow.collectLatest {
                tvMessage.text = it.toString()
            }
        }
    }
}