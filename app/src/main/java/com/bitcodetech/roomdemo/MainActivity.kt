package com.bitcodetech.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roomDb: AppDatabase =
            Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "db_my_tasks"
            ).build()

        val taskDao = roomDb.getTaskDao()

        taskDao.addTask(
            Task(
                101,
                "Pay bills",
                1,
                false
            )
        )
        taskDao.addTask(
            Task(
                102,
                "Complete pending assignments",
                2,
                false
            )
        )
        taskDao.addTask(
            Task(
                103,
                "Book tickets",
                2,
                true
            )
        )

        val tasks = taskDao.getTasks()
        for(task in tasks) {
            Log.e("tag", task.toString())
        }
    }
}