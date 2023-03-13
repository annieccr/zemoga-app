package com.example.zemoga_app.postList.model.api

data class Data (
    val users: List<User>,
    val comments: List<Comment>,
    val posts: List<Post>,
)