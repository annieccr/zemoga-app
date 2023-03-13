package com.example.zemoga_app.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zemoga_app.postList.ui.model.room.*

@Database(entities = [Comment::class, Post::class, User::class], version = 2)
abstract class DbDataSource : RoomDatabase() {
    abstract fun commentDao(): CommentDao
    abstract fun postDao(): PostDao
    abstract fun userDao(): UserDao
}