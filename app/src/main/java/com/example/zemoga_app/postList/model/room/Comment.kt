package com.example.zemoga_app.postList.ui.model.room

import androidx.room.*

@Entity(tableName = "comments")
data class Comment (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "postId") val postId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "body") val body: String
)

@Dao
interface CommentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(comment: Comment)

    @Query("SELECT * FROM comments WHERE postId =:id")
    fun getAllByPost(id: Int): List<Comment>

    @Delete
    fun delete(comment: Comment)
}

