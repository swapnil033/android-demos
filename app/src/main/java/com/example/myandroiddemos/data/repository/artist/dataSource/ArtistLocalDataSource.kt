package com.example.myandroiddemos.data.repository.artist.dataSource

import com.example.myandroiddemos.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB() : List<Artist>

    suspend fun saveArtistsToDB(artists : List<Artist>)

    suspend fun clearAll()

}