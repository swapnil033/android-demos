package com.example.myandroiddemos.data.repository.movie.dataSource

import com.example.myandroiddemos.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache() : List<Movie>

    suspend fun saveMoviesToCache(movies : List<Movie>)

}