package com.example.zemoga_app.postList.model.api

data class Comment(
    val id: Int,
    val postId: Int,
    val name: String,
    val body: String
)