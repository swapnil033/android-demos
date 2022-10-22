package com.example.myandroiddemos.data.repository.movie

import android.util.Log
import com.example.myandroiddemos.data.model.movie.Movie
import com.example.myandroiddemos.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.myandroiddemos.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.myandroiddemos.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.myandroiddemos.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies : List<Movie> = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI() : List<Movie> {
        lateinit var  movieList : List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null)
                movieList = body.movies
        }catch (ex : Exception){
            Log.i("TAG", "getMoviesFromAPI: ${ex.message}" )
        }

        return movieList
    }

    suspend fun getMoviesFromDB() : List<Movie> {
        lateinit var  movieList : List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (ex : Exception){
            Log.i("TAG", "getMoviesFromAPI: ${ex.message}" )
        }

        if(movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie> {
        lateinit var  movieList : List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (ex : Exception){
            Log.i("TAG", "getMoviesFromAPI: ${ex.message}" )
        }

        if(movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }

}