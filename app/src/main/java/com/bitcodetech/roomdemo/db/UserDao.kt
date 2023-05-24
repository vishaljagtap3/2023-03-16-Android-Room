package com.bitcodetech.roomdemo.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class UserDao {
    @Query("select * from users")
    abstract fun getUsers() : List<User>

    @Insert
    abstract fun addUser(user : User)

    @Delete
    abstract fun deleteUser(user : User)
}