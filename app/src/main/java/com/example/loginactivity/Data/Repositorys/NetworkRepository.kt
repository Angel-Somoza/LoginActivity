package com.example.loginactivity.Data.Repositorys

import com.example.loginactivity.Data.Api.DonutApi
import com.example.loginactivity.Data.Api.Models.User
import com.example.loginactivity.Data.LocalData.Userdao
import javax.inject.Inject

class NetworkRepository @Inject constructor( private val api : DonutApi) {

   suspend fun getDonuts() = api.getDonuts()
}