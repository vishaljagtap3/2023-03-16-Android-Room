package com.bitcodetech.roomdemo.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Task::class, User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTaskDao() : TaskDao
    abstract fun getUserDao() : UserDao
}