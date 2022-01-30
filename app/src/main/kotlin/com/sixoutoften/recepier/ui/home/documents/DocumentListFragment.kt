package com.sixoutoften.recepier.ui.home.documents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sixoutoften.recepier.databinding.FragmentDocumentListBinding
import com.sixoutoften.recepier.util.RLogger
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class DocumentListFragment : Fragment() {

    private val viewModel: DocumentListViewModel by viewModels()

    private lateinit var binding: FragmentDocumentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDocumentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initTest()
        subscribeAll()
    }

    private fun subscribeAll() {
        lifecycleScope.launchWhenCreated {
            viewModel.stateFlow.collectLatest {
                binding.txtMessage.text = it.toString()
            }
        }
    }
}