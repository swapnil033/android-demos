package com.example.myandroiddemos.presentation.di.artist

import com.example.myandroiddemos.domain.useCase.GetArtistsUseCase
import com.example.myandroiddemos.domain.useCase.UpdateArtistsUseCase
import com.example.myandroiddemos.presentation.artist.ArtistActivityViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent

@InstallIn(ActivityComponent::class)
@Module
class ArtistModule {

    @ActivityScoped
    @Provides
    fun provideArtistActivityViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        getUpdateArtistsUseCase: UpdateArtistsUseCase
    ) : ArtistActivityViewModelFactory {
        return ArtistActivityViewModelFactory(
            getArtistsUseCase, getUpdateArtistsUseCase
        )
    }
}