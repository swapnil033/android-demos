package com.example.myandroiddemos.presentation.di.core

import com.example.myandroiddemos.data.repository.artist.ArtistRepositoryImpl
import com.example.myandroiddemos.data.repository.artist.dataSource.ArtistCacheDataSource
import com.example.myandroiddemos.data.repository.artist.dataSource.ArtistLocalDataSource
import com.example.myandroiddemos.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.myandroiddemos.data.repository.movie.MovieRepositoryImpl
import com.example.myandroiddemos.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.myandroiddemos.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.myandroiddemos.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.myandroiddemos.data.repository.tvShow.TvShowsRepositoryImpl
import com.example.myandroiddemos.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.myandroiddemos.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.myandroiddemos.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.myandroiddemos.domain.repository.ArtistRepository
import com.example.myandroiddemos.domain.repository.MovieRepository
import com.example.myandroiddemos.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ) : ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ) : MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowsRepository(
        tvShowsRemoteDataSource: TvShowRemoteDataSource,
        tvShowsLocalDataSource: TvShowLocalDataSource,
        tvShowsCacheDataSource: TvShowCacheDataSource
    ) : TvShowsRepository {
        return TvShowsRepositoryImpl(
            tvShowsRemoteDataSource, tvShowsLocalDataSource, tvShowsCacheDataSource
        )
    }

}