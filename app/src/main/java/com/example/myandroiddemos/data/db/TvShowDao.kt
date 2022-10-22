package com.example.myandroiddemos.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myandroiddemos.data.model.tvShow.Tv

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(list: List<Tv>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteTvShows()

    @Query("SELECT * From popular_tv_shows")
    suspend fun getTvShows() : List<Tv>
}