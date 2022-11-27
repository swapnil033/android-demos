package com.example.myandroiddemos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.myandroiddemos.data.util.Resource
import com.example.myandroiddemos.databinding.FragmentNewsBinding
import com.example.myandroiddemos.presentation.MainActivity
import com.example.myandroiddemos.presentation.adapter.NewsAdapter
import com.example.myandroiddemos.presentation.viewModel.NewsViewModel


class NewsFragment : Fragment() {

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var viewModel: NewsViewModel
    private lateinit var binding : FragmentNewsBinding

    private var country = "us"
    private var page = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(requireContext()),
            R.layout.fragment_news,
            container,
            false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        initRecyclerView()
        viewNewsList()
    }

    private fun viewNewsList() {
        viewModel.getNewsHeadLines(country, page)
        viewModel.newsHeadLines.observe(viewLifecycleOwner){response ->
            when(response){
                is Resource.Loading -> {
                    showProgress()
                }
                is Resource.Error -> {
                    hideProgress()
                    response.message?.let {
                        Toast.makeText(requireActivity(), "error occurred : $it", Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Success -> {
                    hideProgress()
                    response.data?.let {
                        newsAdapter.differ.submitList(it.articles?.toList())
                    }
                }
            }
        }
    }

    private fun initRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvHeadlineNews.adapter = newsAdapter

    }

    private fun showProgress(){
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgress(){
        binding.progressBar.visibility = View.GONE
    }
}