package com.bitcodetech.roomdemo.db

import androidx.room.*

@Dao
interface TaskDao {

    @Query("select * from tasks")
    fun getTasks() : List<Task>

    @Insert
    fun addTask(task : Task)

    @Query("delete from tasks where id = :id")
    fun deleteTask(id : Int)

    @Update
    fun update(task : Task)

}