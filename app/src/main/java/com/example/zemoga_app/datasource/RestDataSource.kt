package com.example.zemoga_app.datasource

import com.example.zemoga_app.postList.model.api.Comment
import com.example.zemoga_app.postList.model.api.Post
import com.example.zemoga_app.postList.model.api.User

import retrofit2.http.GET

interface RestDataSource {
    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("comments")
    suspend fun getComments(): List<Comment>

    @GET("posts")
    suspend fun getPosts(): List<Post>
}