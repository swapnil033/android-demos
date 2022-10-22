package com.example.myandroiddemos.data.repository.artist.dataSource

import com.example.myandroiddemos.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache() : List<Artist>

    suspend fun saveArtistsToCache(artists : List<Artist>)

}