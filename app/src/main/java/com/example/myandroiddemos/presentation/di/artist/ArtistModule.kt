package com.example.myandroiddemos.presentation.di.artist

import com.example.myandroiddemos.domain.useCase.GetArtistsUseCase
import com.example.myandroiddemos.domain.useCase.UpdateArtistsUseCase
import com.example.myandroiddemos.presentation.artist.ArtistActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
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