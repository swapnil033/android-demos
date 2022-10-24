package com.example.myandroiddemos.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myandroiddemos.domain.useCase.GetArtistsUseCase
import com.example.myandroiddemos.domain.useCase.UpdateArtistsUseCase

class ArtistActivityViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val getUpdateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        emit(getArtistsUseCase.execute())
    }

    fun updateArtists() = liveData {
        emit(getUpdateArtistsUseCase.execute())
    }

}