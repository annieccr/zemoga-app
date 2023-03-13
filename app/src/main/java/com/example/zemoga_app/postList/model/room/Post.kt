package com.example.zemoga_app.postList.ui.model.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "posts")
data class Post (
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "userId") val userId: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "body")val body: String,
    @ColumnInfo(name = "favorite") val favorite: Boolean
)

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: Post)

    @Query("SELECT * FROM posts ORDER BY favorite DESC")
    fun getAll(): LiveData<List<Post>>

    @Query("SELECT * FROM posts WHERE id = :id")
    fun getPost(id: Int): Post

    @Delete
    fun delete(post: Post)

    @Query("DELETE FROM posts")
    fun deleteAll()

    @Query("UPDATE posts SET favorite=:favorite WHERE id = :id")
    fun update(favorite: Boolean, id: Int);
}