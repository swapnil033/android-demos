package com.example.myandroiddemos

import kotlinx.coroutines.*

class UserDataManager {

    suspend fun getTotalUserCount() : Int {
        var count = 0

        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 20
        }

        val count2 = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 50
        }

        return count + count2.await()
    }

}