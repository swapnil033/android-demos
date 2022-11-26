package com.example.myandroiddemos.presentation.di.core

import com.example.myandroiddemos.data.db.ArtistDao
import com.example.myandroiddemos.data.db.MovieDao
import com.example.myandroiddemos.data.db.TvShowDao
import com.example.myandroiddemos.data.repository.artist.dataSource.ArtistLocalDataSource
import com.example.myandroiddemos.data.repository.artist.dataSourceImpl.ArtistLocalDataSourceImpl
import com.example.myandroiddemos.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.myandroiddemos.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.example.myandroiddemos.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.myandroiddemos.data.repository.tvShow.dataSourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao) : TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

}