package com.example.myandroiddemos.domain.repository

import com.example.myandroiddemos.data.model.tvShow.Tv

interface TvShowsRepository {

    suspend fun getTvShows() : List<Tv>?

    suspend fun updateShows() : List<Tv>?

}