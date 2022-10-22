package com.example.myandroiddemos.data.repository.tvShow.dataSourceImpl

import com.example.myandroiddemos.data.db.MovieDao
import com.example.myandroiddemos.data.db.TvShowDao
import com.example.myandroiddemos.data.model.tvShow.Tv
import com.example.myandroiddemos.data.repository.tvShow.dataSource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<Tv> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvList: List<Tv>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteTvShows()
        }
    }
}