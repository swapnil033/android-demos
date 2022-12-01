package com.example.myandroiddemos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.myandroiddemos.databinding.FragmentInfoBinding
import com.example.myandroiddemos.presentation.MainActivity
import com.example.myandroiddemos.presentation.viewModel.NewsViewModel
import com.google.android.material.snackbar.Snackbar


class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding
    private lateinit var viewModel : NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args : InfoFragmentArgs by navArgs()
        val article = args.selectedArticle

        viewModel = (requireActivity() as MainActivity).viewModel

        binding.webVIew.apply {
            webViewClient = WebViewClient()
            if (article.url != null && article.url!!.isNotEmpty())
                loadUrl(article.url!!)
        }

        viewModel.message.observe(viewLifecycleOwner){
            it.getContentIfNotHandled()?.let {
                Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
            }
        }

        binding.saveFab.setOnClickListener {
            viewModel.saveData(article)
        }
    }
}