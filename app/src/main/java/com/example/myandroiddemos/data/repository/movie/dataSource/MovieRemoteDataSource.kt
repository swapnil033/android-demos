package com.example.myandroiddemos.data.repository.movie.dataSource

import com.example.myandroiddemos.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies() : Response<MovieList>

}