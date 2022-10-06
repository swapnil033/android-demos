package com.example.myandroiddemos.model

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers() : List<User> {
        delay(8000)
        return listOf(
            User(1, "Swapnil"),
            User(2, "Sankalp"),
            User(3, "Iron Man"),
            User(4, "Hulk")
        )

    }

}