package com.example.myandroiddemos.data.repository.tvShow.dataSourceImpl

import com.example.myandroiddemos.data.model.movie.Movie
import com.example.myandroiddemos.data.model.tvShow.Tv
import com.example.myandroiddemos.data.repository.tvShow.dataSource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowsList = ArrayList<Tv>()

    override suspend fun getTvShowsFromCache(): List<Tv> {
        return tvShowsList
    }

    override suspend fun saveTvShowsToCache(tvShowList: List<Tv>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShowList)
    }
}