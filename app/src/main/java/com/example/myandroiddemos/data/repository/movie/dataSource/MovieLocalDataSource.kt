package com.example.myandroiddemos.data.repository.movie.dataSource

import com.example.myandroiddemos.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB() : List<Movie>

    suspend fun saveMoviesToDB(movies : List<Movie>)

    suspend fun clearAll()

}