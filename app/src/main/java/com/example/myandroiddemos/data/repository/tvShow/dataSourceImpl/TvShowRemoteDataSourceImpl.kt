package com.example.myandroiddemos.data.repository.tvShow.dataSourceImpl

import com.example.myandroiddemos.data.api.TMDBService
import com.example.myandroiddemos.data.model.tvShow.TvList
import com.example.myandroiddemos.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey : String

) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvList> = tmdbService.getPopularTvShows(apiKey)
}