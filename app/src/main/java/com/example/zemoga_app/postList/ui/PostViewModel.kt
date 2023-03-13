package com.example.zemoga_app.postList.ui

import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zemoga_app.postList.ui.model.room.Comment
import com.example.zemoga_app.postList.ui.model.room.Post
import com.example.zemoga_app.postList.ui.model.room.User
import com.example.zemoga_app.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel (){
    private val _tabSelected = MutableLiveData<Int>()
    val tabSelected: LiveData<Int> = _tabSelected

    val posts: LiveData<List<Post>> by lazy {
        dataRepository.getAllPosts()
    }

    var dialog by mutableStateOf(false)
    var post by mutableStateOf(Post(0, 0, "","", false))
    var user by mutableStateOf(User(0, "", "","","",""))
    var comments by mutableStateOf(listOf<Comment>())
    var isLoading by mutableStateOf(false)

    fun openDialog (){
        dialog = true
    }
    fun closeDialog (){
        dialog = false
    }
    fun setTab (index:Int){
        _tabSelected.value = index
    }
    fun savePosts() = viewModelScope.launch(Dispatchers.IO){
        isLoading = true
        dataRepository.saveData()
        isLoading = false
    }
    fun getPost(id: Int) = viewModelScope.launch(Dispatchers.IO){
        post = dataRepository.getPost(id)
        user = dataRepository.getUser(post.userId)
        comments = dataRepository.getCommentsById(id)
    }
    fun updatePost(favorite:Boolean, id: Int) {
        viewModelScope.launch(Dispatchers.IO){
            dataRepository.updatePost(favorite, id)
        }
    }
    fun deleteAllPosts() = viewModelScope.launch(Dispatchers.IO){
        closeDialog()
        isLoading = true
        dataRepository.deleteAllPosts()
        isLoading = false
    }

}