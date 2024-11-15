package com.example.loginactivity.Data.Repositorys

import com.example.loginactivity.Data.Api.DonutApi
import javax.inject.Inject

class NetworkRepository @Inject constructor( private val api : DonutApi) {

   suspend fun getDonuts() = api.getDonuts()
}