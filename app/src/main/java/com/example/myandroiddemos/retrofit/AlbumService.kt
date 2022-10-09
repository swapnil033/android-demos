package com.example.myandroiddemos.retrofit

import com.example.myandroiddemos.model.Album
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums() : Response<Album>

    @GET("/albums")
    suspend fun getAlbums(@Query("userId") userId : Int) : Response<Album>

}