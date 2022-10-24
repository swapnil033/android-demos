package com.example.myandroiddemos.presentation.movie

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myandroiddemos.data.model.movie.Movie
import com.example.myandroiddemos.databinding.ListItemBinding

class MovieAdapter() : RecyclerView.Adapter<MovieViewHolder>(){
    private var movieList = ArrayList<Movie>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(movies: List<Movie>){
        movieList.clear()
        movieList = ArrayList(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MovieViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(movie: Movie){
        binding.titleTextView.text = movie.title
        binding.descriptionTextView.text = movie.overview

        val posterUrl = "https://image.tmdb.org/t/p/w500" + movie.posterPath

        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }

}