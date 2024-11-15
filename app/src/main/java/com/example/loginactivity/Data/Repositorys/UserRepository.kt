package com.example.loginactivity.Data.Repositorys

import com.example.loginactivity.Data.Models.User
import com.example.loginactivity.Data.Room.Userdao
import javax.inject.Inject


class UserRepository @Inject constructor(private val userdao: Userdao) {
    suspend fun InsertUser(username: String, password: String): Boolean {
        return try {
            val user = User(username, password)
            val result = userdao.InsertUser(user)
            result != -1L
        } catch (e: Exception) {
            false
        }
    }

    suspend fun CheckUser(username: String, password: String): Boolean {
        return try {
            val user = userdao.CheckUser(username)
            user?.password == password
        } catch (e: Exception) {
            false
        }
    }
}