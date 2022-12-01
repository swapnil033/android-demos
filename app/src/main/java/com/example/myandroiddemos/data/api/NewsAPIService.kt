package com.example.myandroiddemos.data.api

import com.example.myandroiddemos.BuildConfig
import com.example.myandroiddemos.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country : String,
        @Query("page") page : Int,
        @Query("apiKey") key : String = BuildConfig.API_KEY
    ) : Response<APIResponse>

    @GET("/v2/top-headlines")
    suspend fun getSearchedHeadlines(
        @Query("country") country : String,
        @Query("q") searchQuery : String,
        @Query("page") page : Int,
        @Query("apiKey") key : String = BuildConfig.API_KEY
    ) : Response<APIResponse>

}