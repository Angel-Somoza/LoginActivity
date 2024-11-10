package com.example.loginactivity.Data.Api

import com.example.loginactivity.Data.Api.Json.Donut
import retrofit2.http.GET

interface DonutApi {
    @GET("donuts")
    //tenemos nueva forma para hacerlo.
    suspend fun getDonuts(): List<Donut>
}