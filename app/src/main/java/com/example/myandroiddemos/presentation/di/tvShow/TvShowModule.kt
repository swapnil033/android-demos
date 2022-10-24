package com.example.myandroiddemos.presentation.di.tvShow

import com.example.myandroiddemos.domain.useCase.*
import com.example.myandroiddemos.presentation.artist.ArtistActivityViewModelFactory
import com.example.myandroiddemos.presentation.movie.MovieActivityViewModelFactory
import com.example.myandroiddemos.presentation.tvShow.TvShowActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowActivityViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        getUpdateTvShowsUseCase: UpdateTvShowsUseCase
    ) : TvShowActivityViewModelFactory {
        return TvShowActivityViewModelFactory(
            getTvShowsUseCase, getUpdateTvShowsUseCase
        )
    }
}