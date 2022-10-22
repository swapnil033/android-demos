package com.example.myandroiddemos.data.api

import com.example.myandroiddemos.data.model.artist.ArtistList
import com.example.myandroiddemos.data.model.movie.MovieList
import com.example.myandroiddemos.data.model.tvShow.TvList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") api_key : String) : Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") api_key : String) : Response<TvList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") api_key : String) : Response<ArtistList>

}