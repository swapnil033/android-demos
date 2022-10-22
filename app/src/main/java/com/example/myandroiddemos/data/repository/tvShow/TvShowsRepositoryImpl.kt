package com.example.myandroiddemos.data.repository.tvShow

import android.util.Log
import com.example.myandroiddemos.data.model.tvShow.Tv
import com.example.myandroiddemos.data.repository.tvShow.dataSource.*
import com.example.myandroiddemos.domain.repository.TvShowsRepository

class TvShowsRepositoryImpl(

    private val tvShowsRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowsLocalDataSource: TvShowLocalDataSource,
    private val tvShowsCacheDataSource: TvShowCacheDataSource
) : TvShowsRepository {
    override suspend fun getTvShows(): List<Tv> {
        return getTvShowsFromCache()
    }

    override suspend fun updateShows(): List<Tv> {
        val newListOfTvShows : List<Tv> = getTvShowsFromAPI()
        tvShowsLocalDataSource.clearAll()
        tvShowsLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowsCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI() : List<Tv> {
        lateinit var tvShows : List<Tv>

        try {
            val response = tvShowsRemoteDataSource.getTvShows()
            val body = response.body()
            if(body != null)
                tvShows = body.tvs
        }catch (ex : Exception){
            Log.i("TAG", "getTvShowsFromAPI: ${ex.message}")
        }

        return tvShows
    }

    suspend fun getTvShowsFromDB() : List<Tv> {
        lateinit var tvShows : List<Tv>

        try {
            tvShows = tvShowsLocalDataSource.getTvShowsFromDB()
        }catch (ex : Exception){
            Log.i("TAG", "getTvShowsFromAPI: ${ex.message}")
        }

        if(tvShows.isNotEmpty()){
            return tvShows
        }else{
            tvShows = getTvShowsFromAPI()
            tvShowsLocalDataSource.saveTvShowsToDB(tvShows)
        }

        return tvShows
    }

    suspend fun getTvShowsFromCache() : List<Tv> {
        lateinit var tvShows : List<Tv>

        try {
            tvShows = tvShowsCacheDataSource.getTvShowsFromCache()
        }catch (ex : Exception){
            Log.i("TAG", "getTvShowsFromAPI: ${ex.message}")
        }

        if(tvShows.isNotEmpty()){
            return tvShows
        }else{
            tvShows = getTvShowsFromDB()
            tvShowsCacheDataSource.saveTvShowsToCache(tvShows)
        }

        return tvShows
    }

}