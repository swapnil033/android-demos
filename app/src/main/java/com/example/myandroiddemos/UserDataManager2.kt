package com.example.myandroiddemos

import kotlinx.coroutines.*

class UserDataManager2 {
    var count = 0
    lateinit var count2 : Deferred<Int>

    suspend fun getTotalUserCount() : Int {
        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                count = 20
            }

            count2 = async(Dispatchers.IO) {
                delay(3000)
                return@async 50
            }

        }

        return count + count2.await()
    }
}