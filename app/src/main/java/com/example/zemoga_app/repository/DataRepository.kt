package com.example.zemoga_app.repository

import androidx.lifecycle.LiveData
import com.example.zemoga_app.datasource.RestDataSource
import com.example.zemoga_app.postList.ui.model.room.*
import javax.inject.Inject

interface DataRepository {
    suspend fun saveData()
    fun getAllPosts(): LiveData<List<Post>>
    fun getPost(id: Int): Post
    fun getUser(id: Int): User
    fun getCommentsById(id: Int): List<Comment>
    fun updatePost(favorite: Boolean, id: Int)
    fun deleteAllPosts()
}

class DataRepositoryImp @Inject constructor(
    private val dataSource: RestDataSource,
    private val postDao: PostDao,
    private val userDao: UserDao,
    private val commentDao: CommentDao
) : DataRepository {
    override suspend fun saveData() {
        val users = dataSource.getUsers()
        val comments = dataSource.getComments()
        val posts = dataSource.getPosts()
        for (post in posts) {
            val post2 = Post(post.id, post.userId, post.title, post.body, false)
            postDao.insert(post2)
        }
        for (user in users) {
            val user2 = User(user.id, user.name, user.username, user.email, user.phone, user.website)
            userDao.insert(user2)
        }
        for (comment in comments) {
            val comment2 = Comment(comment.id, comment.postId, comment.name, comment.body)
            commentDao.insert(comment2)
        }
    }

    override fun getAllPosts(): LiveData<List<Post>> = postDao.getAll()

    override fun getPost(id: Int): Post = postDao.getPost(id)

    override fun getUser(id: Int): User = userDao.getUser(id)

    override fun getCommentsById(id: Int): List<Comment> = commentDao.getAllByPost(id)

    override fun updatePost(favorite: Boolean, id: Int) = postDao.update(favorite,id)

    override fun deleteAllPosts() = postDao.deleteAll()
}