package com.bitcodetech.roomdemo

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import androidx.room.Room
import com.bitcodetech.roomdemo.db.AppDatabase
import com.bitcodetech.roomdemo.db.Task

class MyContentProvider : ContentProvider() {

    private lateinit var db : AppDatabase

    companion object {

        private const val TASKS_ALL = 1
        private const val TASK_BY_ID = 2
        private const val USERS_ALL = 3
        private const val USER_BY_ID = 4

        private val uriMather = UriMatcher(-1)
        init {
            uriMather.addURI("in.bitcode.contents", "tasks", TASKS_ALL)
            uriMather.addURI("in.bitcode.contents", "tasks/#", TASK_BY_ID)
            uriMather.addURI("in.bitcode.contents", "users", USERS_ALL)
            uriMather.addURI("in.bitcode.contents", "users/#", USER_BY_ID)
        }
    }

    override fun onCreate(): Boolean {
        db = Room.databaseBuilder(
            context!!,
            AppDatabase::class.java,
            "db_my_tasks",
        ).allowMainThreadQueries()
            .build()
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        when(uriMather.match(uri)) {
            TASKS_ALL -> {
                return db.query("select * from tasks", null)
            }
            TASK_BY_ID -> {
                return db.query(
                    "select * from tasks where id = ?",
                    arrayOf(uri.pathSegments[1])
                )
            }
            USERS_ALL -> {
                return db.query("select * from users", null)
            }
            USER_BY_ID -> {
                return db.query(
                    "select * from users where id = ?",
                    arrayOf(uri.pathSegments[1])
                )
            }
        }

        return null
    }

    /*override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selction: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        if(uri.pathSegments[0].equals("tasks")) {
            if(uri.pathSegments.size == 1) {
                return db.query("select * from tasks", null)
            }

            if(uri.pathSegments.size == 2) {
                return db.query(
                    "select * from tasks where id = ?",
                    arrayOf(uri.pathSegments[1])
                )
            }
        }

        if(uri.pathSegments[0].equals("users")) {
            if(uri.pathSegments.size == 1) {
                return db.query("select * from users", null)
            }

            if(uri.pathSegments.size == 2) {
                return db.query(
                    "select * from users where id = ?",
                    arrayOf(uri.pathSegments[1])
                )
            }
        }

        return null
    }*/

    override fun getType(p0: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        when(uriMather.match(uri)) {
            TASKS_ALL -> {
                db.getTaskDao().addTask(
                    Task(
                        values!!.getAsInteger("id"),
                        values.getAsString("task_title"),
                        values!!.getAsInteger("task_priority"),
                        values!!.getAsBoolean("is_completed"),
                    )
                )

                return Uri.withAppendedPath(uri, "${values.getAsInteger("id")}")
            }
            USERS_ALL -> {

            }
        }
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        TODO("Not yet implemented")
    }


}