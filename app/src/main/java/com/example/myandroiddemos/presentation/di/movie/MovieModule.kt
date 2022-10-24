package com.example.myandroiddemos.presentation.di.movie

import com.example.myandroiddemos.domain.useCase.GetArtistsUseCase
import com.example.myandroiddemos.domain.useCase.GetMoviesUseCase
import com.example.myandroiddemos.domain.useCase.UpdateArtistsUseCase
import com.example.myandroiddemos.domain.useCase.UpdateMoviesUseCase
import com.example.myandroiddemos.presentation.artist.ArtistActivityViewModelFactory
import com.example.myandroiddemos.presentation.movie.MovieActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieActivityViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        getUpdateMoviesUseCase: UpdateMoviesUseCase
    ) : MovieActivityViewModelFactory {
        return MovieActivityViewModelFactory(
            getMoviesUseCase, getUpdateMoviesUseCase
        )
    }
}