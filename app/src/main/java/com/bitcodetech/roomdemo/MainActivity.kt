package com.bitcodetech.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bitcodetech.roomdemo.db.AppDatabase
import com.bitcodetech.roomdemo.db.Task
import com.bitcodetech.roomdemo.db.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val roomDb: AppDatabase =
            Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "db_my_tasks"
            ).allowMainThreadQueries()
                .build()

        val usersDao = roomDb.getUserDao()
        usersDao.addUser(
            User(
                901,
                "ABC",
                "abc@bitcode.in"
            )
        )

        usersDao.addUser(
            User(
                902,
                "PQR",
                "pqr@bitcode.in"
            )
        )

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
        )*/

       /* val roomDb: AppDatabase =
            Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "db_my_tasks"
            ).allowMainThreadQueries()
                .build()

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
        for (task in tasks) {
            Log.e("tag", task.toString())
        }*/
    }
}