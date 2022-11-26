package com.example.myandroiddemos.presentation.di.core

import com.example.myandroiddemos.data.repository.artist.dataSource.ArtistCacheDataSource
import com.example.myandroiddemos.data.repository.artist.dataSourceImpl.ArtistCacheDataSourceImpl
import com.example.myandroiddemos.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.myandroiddemos.data.repository.movie.dataSourceImpl.MovieCacheDataSourceImpl
import com.example.myandroiddemos.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.myandroiddemos.data.repository.tvShow.dataSourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideArtistCacheDataSource() : ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource() : TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

}