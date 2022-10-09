package com.example.myandroiddemos.retrofit

import com.example.myandroiddemos.model.Album
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums() : Response<Album>

}