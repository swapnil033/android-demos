package com.example.myandroiddemos.presentation.di.core

import com.example.myandroiddemos.data.api.TMDBService
import com.example.myandroiddemos.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.myandroiddemos.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.example.myandroiddemos.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.myandroiddemos.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.myandroiddemos.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.myandroiddemos.data.repository.tvShow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(
            tmdbService,
            apiKey
        )
    }

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService,
            apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService) : TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService,
            apiKey
        )
    }

}