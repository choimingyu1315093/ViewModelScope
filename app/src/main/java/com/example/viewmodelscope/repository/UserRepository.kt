package com.example.viewmodelscope.repository

import com.example.viewmodelscope.model.User
import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User>{
        delay(8000)
        val users = listOf(
            User(1, "Choi"),
            User(2, "Min"),
            User(3, "Gyu")
        )
        return users
    }
}