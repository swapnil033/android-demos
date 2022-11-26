package com.example.myandroiddemos.presentation.di.tvShow

import com.example.myandroiddemos.domain.useCase.*
import com.example.myandroiddemos.presentation.artist.ArtistActivityViewModelFactory
import com.example.myandroiddemos.presentation.movie.MovieActivityViewModelFactory
import com.example.myandroiddemos.presentation.tvShow.TvShowActivityViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent

@InstallIn(ActivityComponent::class)
@Module
class TvShowModule {

    @ActivityScoped
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