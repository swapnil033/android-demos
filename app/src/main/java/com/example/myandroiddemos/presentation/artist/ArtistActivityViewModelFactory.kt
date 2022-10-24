package com.example.myandroiddemos.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myandroiddemos.domain.useCase.GetArtistsUseCase
import com.example.myandroiddemos.domain.useCase.UpdateArtistsUseCase

class ArtistActivityViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val getUpdateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistActivityViewModel(getArtistsUseCase, getUpdateArtistsUseCase) as T
    }

}