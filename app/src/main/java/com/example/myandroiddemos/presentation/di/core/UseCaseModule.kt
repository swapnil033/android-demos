package com.example.myandroiddemos.presentation.di.core

import com.example.myandroiddemos.domain.repository.ArtistRepository
import com.example.myandroiddemos.domain.repository.MovieRepository
import com.example.myandroiddemos.domain.repository.TvShowsRepository
import com.example.myandroiddemos.domain.useCase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    fun provideGetArtistsUseCase(artistRepository : ArtistRepository) : GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistRepository : ArtistRepository) : UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository) : GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository) : UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowsUseCase(tvShowsRepository: TvShowsRepository) : GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowsRepository)
    }

    @Provides
    fun provideUpdateTvShowsUseCase(tvShowsRepository: TvShowsRepository) : UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowsRepository)
    }

}