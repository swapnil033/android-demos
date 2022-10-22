package com.example.myandroiddemos.data.repository.artist

import android.util.Log
import com.example.myandroiddemos.data.model.artist.Artist
import com.example.myandroiddemos.data.repository.artist.dataSource.*
import com.example.myandroiddemos.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist> {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist> {
        val newListOfArtist = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtist)
        artistCacheDataSource.saveArtistsToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistsFromAPI() : List<Artist>{
        lateinit var artists : List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if(body != null)
                artists = body.results
        }catch (ex : Exception){
            Log.i("TAG", "getArtistsFromAPI: ${ex.message}" )
        }

        return artists
    }

    suspend fun getArtistsFromDB() : List<Artist>{
        lateinit var artists : List<Artist>

        try {
            artists = artistLocalDataSource.getArtistsFromDB()
        }catch (ex : Exception){
            Log.i("TAG", "getArtistsFromAPI: ${ex.message}" )
        }

        if(artists.isNotEmpty()){
            return artists
        }else{
            artists = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artists)
        }

        return artists
    }

    suspend fun getArtistsFromCache() : List<Artist>{
        lateinit var artists : List<Artist>

        try {
            artists = artistCacheDataSource.getArtistsFromCache()
        }catch (ex : Exception){
            Log.i("TAG", "getArtistsFromAPI: ${ex.message}" )
        }

        if(artists.isNotEmpty()){
            return artists
        }else{
            artists = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artists)
        }

        return artists
    }
}