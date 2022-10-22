package com.example.myandroiddemos.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myandroiddemos.data.model.movie.Movie


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(list: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteMovies()

    @Query("SELECT * From popular_movies")
    suspend fun getMovies() : List<Movie>
}