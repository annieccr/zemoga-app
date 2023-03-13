package com.example.zemoga_app.postList.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.zemoga_app.postList.ui.model.room.Post
import com.example.zemoga_app.postList.ui.PostViewModel

@Composable
fun List (tabSelected: Int, goToDetail: (Int) -> Unit, viewModel: PostViewModel, posts:List<Post>){
    if (tabSelected == 0){
        Box(modifier = Modifier.verticalScroll(rememberScrollState())){
            Column(modifier = Modifier.fillMaxSize()) {
                for (post in posts){
                    PostItem(post, goToDetail, viewModel)
                }
            }
        }
    }else{
        Box(modifier = Modifier.verticalScroll(rememberScrollState())){
            Column() {
                for (post in posts){
                   if(post.favorite){
                       PostItem(post, goToDetail, viewModel)
                   }
                }
            }
        }
    }
}