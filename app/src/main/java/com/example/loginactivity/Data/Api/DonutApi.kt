package com.example.loginactivity.Data.Api

import com.example.loginactivity.Data.Api.Models.Donut
import retrofit2.http.GET

interface DonutApi {
    @GET("donuts")
    //tenemos nueva forma para hacerlo.
    suspend fun getDonuts(): List<Donut>
}