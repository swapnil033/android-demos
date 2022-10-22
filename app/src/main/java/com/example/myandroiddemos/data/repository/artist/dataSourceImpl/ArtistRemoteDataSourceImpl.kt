package com.example.myandroiddemos.data.repository.artist.dataSourceImpl

import com.example.myandroiddemos.data.api.TMDBService
import com.example.myandroiddemos.data.model.artist.ArtistList
import com.example.myandroiddemos.data.repository.artist.dataSource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey : String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}