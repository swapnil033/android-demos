package com.example.myandroiddemos.domain.repository

import com.example.myandroiddemos.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists() : List<Artist>?

    suspend fun updateArtists() : List<Artist>?
}