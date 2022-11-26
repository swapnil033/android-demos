package com.example.myandroiddemos.presentation.di.core

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.myandroiddemos.data.db.ArtistDao
import com.example.myandroiddemos.data.db.MovieDao
import com.example.myandroiddemos.data.db.TMDBDatabase
import com.example.myandroiddemos.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(app: Application) : TMDBDatabase{
        return Room.databaseBuilder(app, TMDBDatabase::class.java, "TMDBLocal")
            .build()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase) : ArtistDao{
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase) : MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase) : TvShowDao{
        return tmdbDatabase.tvShowDao()
    }

}