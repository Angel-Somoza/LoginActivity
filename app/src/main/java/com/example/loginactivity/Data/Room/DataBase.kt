package com.example.loginactivity.Data.Room

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import com.example.loginactivity.Data.Models.User
@Database(entities = [User::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun Userdao(): Userdao

}
@Dao
interface Userdao{
@Insert(onConflict = OnConflictStrategy.ABORT)
suspend fun InsertUser(user: User) : Long

@Query("SELECT * FROM users WHERE username = :username LIMIT 1")
suspend fun CheckUser(username: String): User?
}



