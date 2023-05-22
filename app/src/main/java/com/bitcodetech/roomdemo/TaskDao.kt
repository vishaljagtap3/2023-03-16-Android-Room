package com.bitcodetech.roomdemo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {

    @Query("select * from tasks")
    fun getTasks() : List<Task>

    @Insert
    fun addTask(task : Task)

}