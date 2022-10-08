package com.example.myandroiddemos.db

class SubscriberRepository(private val dao: SubscriberDAO) {

    val subsciber = dao.getAllSubscriber()

    suspend fun insert(subscriber: Subscriber){
        dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber){
        dao.updateSubscriber(subscriber)
    }

    suspend fun deleteAll(subscriber: Subscriber){
        dao.deleteAll()
    }

}