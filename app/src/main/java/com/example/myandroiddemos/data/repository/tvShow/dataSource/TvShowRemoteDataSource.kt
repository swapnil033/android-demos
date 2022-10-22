package com.example.myandroiddemos.data.repository.tvShow.dataSource

import com.example.myandroiddemos.data.model.tvShow.TvList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows() : Response<TvList>

}