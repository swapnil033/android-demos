package com.example.myandroiddemos.data.repository.artist.dataSource

import com.example.myandroiddemos.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists() : Response<ArtistList>

}