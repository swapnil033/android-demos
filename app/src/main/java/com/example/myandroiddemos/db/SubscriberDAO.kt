package com.example.myandroiddemos.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {

    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber) : Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber) : Int

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber) : Int

    @Query("DELETE FROM subscriber_data_class")
    suspend fun deleteAll() : Int

    @Query("SELECT * FROM subscriber_data_class")
    fun getAllSubscriber() : LiveData<List<Subscriber>>

}