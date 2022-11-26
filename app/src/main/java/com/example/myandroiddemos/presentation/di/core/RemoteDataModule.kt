package com.example.myandroiddemos.presentation.di.core

import com.example.myandroiddemos.BuildConfig
import com.example.myandroiddemos.data.api.TMDBService
import com.example.myandroiddemos.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.myandroiddemos.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.example.myandroiddemos.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.myandroiddemos.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.myandroiddemos.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.myandroiddemos.data.repository.tvShow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule() {

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(
            tmdbService,
            BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService,
            BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService) : TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService,
            BuildConfig.API_KEY
        )
    }

}