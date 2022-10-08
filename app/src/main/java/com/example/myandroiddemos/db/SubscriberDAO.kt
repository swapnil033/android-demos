package com.example.myandroiddemos.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {

    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber)

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("DELETE FROM subscriber_data_class")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber_data_class")
    fun getAllSubscriber() : LiveData<List<Subscriber>>

}