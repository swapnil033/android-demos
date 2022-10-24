package com.example.myandroiddemos.presentation.tvShow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myandroiddemos.R
import com.example.myandroiddemos.databinding.ActivityTvShowBinding
import com.example.myandroiddemos.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowActivityViewModelFactory
    private lateinit var viewModel: TvShowActivityViewModel

    private lateinit var binding : ActivityTvShowBinding
    private lateinit var adapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)


        (application as Injector).createTvShowSubComponent()
            .inject(this)


        viewModel = ViewModelProvider(this, factory)[TvShowActivityViewModel::class.java]

        getRv()

    }

    private fun getRv() {
        adapter = TvShowAdapter()
        binding.recyclerView3.layoutManager = LinearLayoutManager(this)
        binding.recyclerView3.adapter = adapter

        getList()
    }

    private fun getList() {

        viewModel.getTvShows().observe(this){
            adapter.setList(it!!)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies(){
        adapter.setList(listOf())
        binding.progressBar2.visibility = View.VISIBLE
        val response = viewModel.updateTvShows()
        response.observe(this){
            adapter.setList(it!!)
            binding.progressBar2.visibility = View.GONE
        }
    }
}