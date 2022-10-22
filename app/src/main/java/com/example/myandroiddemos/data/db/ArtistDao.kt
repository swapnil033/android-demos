package com.example.myandroiddemos.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myandroiddemos.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(list: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteArtists()

    @Query("SELECT * From popular_artists")
    suspend fun getArtists() : List<Artist>
}