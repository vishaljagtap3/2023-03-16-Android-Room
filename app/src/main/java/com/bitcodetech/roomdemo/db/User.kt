package com.bitcodetech.roomdemo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "user_name")
    val username : String,
    val email : String
)
