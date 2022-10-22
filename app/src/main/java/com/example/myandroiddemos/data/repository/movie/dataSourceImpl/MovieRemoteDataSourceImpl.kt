package com.example.myandroiddemos.data.repository.movie.dataSourceImpl

import com.example.myandroiddemos.data.api.TMDBService
import com.example.myandroiddemos.data.model.movie.MovieList
import com.example.myandroiddemos.data.repository.movie.dataSource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey : String
    ) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}