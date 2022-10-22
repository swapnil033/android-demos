package com.example.myandroiddemos.data.repository.tvShow.dataSource

import com.example.myandroiddemos.data.model.tvShow.Tv


interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache() : List<Tv>

    suspend fun saveTvShowsToCache(tvShowList : List<Tv>)

}