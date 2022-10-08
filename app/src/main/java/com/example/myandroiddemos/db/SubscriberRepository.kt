package com.example.myandroiddemos.db

class SubscriberRepository(private val dao: SubscriberDAO) {

    val subscibers = dao.getAllSubscriber()
    suspend fun insert(subscriber: Subscriber) : Long = dao.insertSubscriber(subscriber)
    suspend fun update(subscriber: Subscriber) : Int = dao.updateSubscriber(subscriber)
    suspend fun delete(subscriber: Subscriber) : Int = dao.deleteSubscriber(subscriber)
    suspend fun deleteAll() : Int = dao.deleteAll()

}