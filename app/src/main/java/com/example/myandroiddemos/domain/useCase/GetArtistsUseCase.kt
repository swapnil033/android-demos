package com.example.myandroiddemos.domain.useCase

import com.example.myandroiddemos.data.model.artist.Artist
import com.example.myandroiddemos.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository : ArtistRepository) {

    suspend fun execute() : List<Artist>? = artistRepository.getArtists()

}