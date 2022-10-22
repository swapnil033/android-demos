package com.example.myandroiddemos.domain.repository

import com.example.myandroiddemos.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?

    suspend fun updateMovies() : List<Movie>?

}