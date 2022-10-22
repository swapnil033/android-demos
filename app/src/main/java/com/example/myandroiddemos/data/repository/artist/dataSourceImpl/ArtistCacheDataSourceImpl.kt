package com.example.myandroiddemos.data.repository.artist.dataSourceImpl

import com.example.myandroiddemos.data.model.artist.Artist
import com.example.myandroiddemos.data.model.movie.Movie
import com.example.myandroiddemos.data.repository.artist.dataSource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList = ArrayList(artists)
    }
}