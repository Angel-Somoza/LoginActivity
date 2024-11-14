package com.example.loginactivity.DI.DatabaseModule

import android.content.Context
import androidx.room.Room
import com.example.loginactivity.Data.LocalData.DataBase
import com.example.loginactivity.Data.LocalData.Userdao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBase_Module {
    @Provides
    @Singleton
    fun ProvideDataBase(@ApplicationContext context: Context): DataBase {
        return Room.databaseBuilder(
            context,
            DataBase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: DataBase): Userdao {
        return database.Userdao()
    }
}