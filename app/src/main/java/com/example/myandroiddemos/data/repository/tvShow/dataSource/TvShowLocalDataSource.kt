package com.example.myandroiddemos.data.repository.tvShow.dataSource

import com.example.myandroiddemos.data.model.tvShow.Tv


interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB() : List<Tv>

    suspend fun saveTvShowsToDB(tvList : List<Tv>)

    suspend fun clearAll()

}