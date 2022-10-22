package com.example.myandroiddemos.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myandroiddemos.data.model.artist.Artist
import com.example.myandroiddemos.data.model.movie.Movie
import com.example.myandroiddemos.data.model.tvShow.Tv

@Database(entities = [Artist::class, Tv::class, Movie::class],
version = 1,
exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun artistDao() : ArtistDao
    abstract fun movieDao() : MovieDao
    abstract fun tvShowDao() : TvShowDao

}