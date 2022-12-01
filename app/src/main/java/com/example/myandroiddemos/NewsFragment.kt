package com.example.myandroiddemos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroiddemos.data.util.Resource
import com.example.myandroiddemos.databinding.FragmentNewsBinding
import com.example.myandroiddemos.presentation.MainActivity
import com.example.myandroiddemos.presentation.adapter.NewsAdapter
import com.example.myandroiddemos.presentation.viewModel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var viewModel: NewsViewModel
    private lateinit var binding : FragmentNewsBinding

    private var country = "us"
    private var page = 1
    private var pages = 0
    private var isLastPage = false
    private var isScrolling = false
    private var isLoading = false

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
        newsAdapter = (activity as MainActivity).newsAdapter

        initRecyclerView()
        viewNewsList()
        setSearchedNews()
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
                        if(it.totalResults!! % 20 == 0){
                            pages = it.totalResults!! / 20
                        }else{
                            pages = it.totalResults!! / 20 + 1
                        }
                        isLastPage = pages == page
                    }
                }
            }
        }
    }

    private fun initRecyclerView() {

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_article", it)
            }
            findNavController().navigate(R.id.action_newsFragment_to_infoFragment, bundle)
        }

        binding.rvHeadlineNews.apply {
            adapter = newsAdapter
            addOnScrollListener(this@NewsFragment.onScrollListener)
        }
    }

    private fun showProgress(){
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgress(){
        isLoading = false
        binding.progressBar.visibility = View.GONE
    }

    private val onScrollListener = object : RecyclerView.OnScrollListener(){
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                isScrolling = true
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = binding.rvHeadlineNews.layoutManager as LinearLayoutManager
            val sizeOfTheCurrentList = layoutManager.itemCount
            val visibleItemCount = layoutManager.childCount
            val topPosition = layoutManager.findFirstVisibleItemPosition()

            val hasReachedToEnd = visibleItemCount + topPosition >= sizeOfTheCurrentList
            val shouldPaginate = !isLoading && !isLastPage && hasReachedToEnd && isScrolling
            if(shouldPaginate){
                page++
                viewModel.getNewsHeadLines(country, page)
                isScrolling = false
            }
        }
    }

    //view searched news
    fun setSearchedNews(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchNews("us", query.toString(), page)
                viewSearchedNews()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                MainScope().launch {
                    viewModel.searchNews("us", newText.toString(), page)
                    viewSearchedNews()
                }
                return false
            }
        })

        binding.searchView.setOnCloseListener(object : SearchView.OnCloseListener{
            override fun onClose(): Boolean {
                initRecyclerView()
                viewNewsList()
                return false
            }
        })
    }

    fun viewSearchedNews(){


        viewModel.searchedNews.observe(viewLifecycleOwner){response ->
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
                        if(it.totalResults!! % 20 == 0){
                            pages = it.totalResults!! / 20
                        }else{
                            pages = it.totalResults!! / 20 + 1
                        }
                        isLastPage = pages == page
                    }
                }
            }
        }
    }
}