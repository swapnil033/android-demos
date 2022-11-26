package com.example.myandroiddemos.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myandroiddemos.R
import com.example.myandroiddemos.databinding.ActivityArtistBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistActivityViewModelFactory

    private lateinit var viewModel: ArtistActivityViewModel

    private lateinit var binding : ActivityArtistBinding
    private lateinit var adapter : ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        viewModel = ViewModelProvider(this, factory)[ArtistActivityViewModel::class.java]

        setRv()

    }

    private fun setRv() {
        adapter = ArtistAdapter()

        binding.recyclerView2.layoutManager = LinearLayoutManager(this)
        binding.recyclerView2.adapter = adapter

        getList()
    }

    private fun getList() {
        binding.progressBar2.visibility = View.VISIBLE
        viewModel.getArtists().observe(this){
            adapter.setList(it!!)
            binding.progressBar2.visibility = View.GONE
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
        val response = viewModel.updateArtists()
        response.observe(this){
            adapter.setList(it!!)
            binding.progressBar2.visibility = View.GONE
        }
    }
}