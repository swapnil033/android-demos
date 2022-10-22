package com.example.myandroiddemos.domain.useCase

import com.example.myandroiddemos.data.model.movie.Movie
import com.example.myandroiddemos.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute() : List<Movie>? = movieRepository.updateMovies()

}