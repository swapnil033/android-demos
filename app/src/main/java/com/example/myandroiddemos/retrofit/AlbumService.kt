package com.example.myandroiddemos.retrofit

import com.example.myandroiddemos.model.Album
import com.example.myandroiddemos.model.AlbumItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbumsByUserId() : Response<Album>

    @GET("/albums")
    suspend fun getAlbumsByUserId(@Query("userId") userId : Int) : Response<Album>

    @GET("/albums/{id}")
    suspend fun getAlbumsByAlbumId(@Path("id") albumId : Int) : Response<AlbumItem>

}