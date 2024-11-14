package com.example.loginactivity.DI.DatabaseModule

import com.example.loginactivity.Data.Api.DonutApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://private-d24209-ocisneros.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    // la intacia de donut api,
    @Provides
    @Singleton
    fun provideDonutApi(retrofit: Retrofit): DonutApi {
        return retrofit.create(DonutApi::class.java)
    }
}