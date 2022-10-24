package com.example.myandroiddemos.presentation.movie

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myandroiddemos.R
import com.example.myandroiddemos.databinding.ActivityMovieBinding
import com.example.myandroiddemos.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : MovieActivityViewModelFactory
    private lateinit var viewModel: MovieActivityViewModel

    private lateinit var binding : ActivityMovieBinding

    private lateinit var adapter: MovieAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        (application as Injector).createMovieSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this, factory)[MovieActivityViewModel::class.java]

        initRv()
    }

    fun initRv(){
        adapter = MovieAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.progressBar.visibility = View.VISIBLE

        val responseLiveData = viewModel.getMovies()
        responseLiveData.observe(this){
            Log.i("MovieActivityTAG", "onCreate: ${it.toString()}")
            adapter.setList(it!!)
            binding.progressBar.visibility = View.GONE
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
        binding.progressBar.visibility = View.VISIBLE
        val response = viewModel.updateMovies()
        response.observe(this){
            adapter.setList(it!!)
            binding.progressBar.visibility = View.GONE
        }
    }

}