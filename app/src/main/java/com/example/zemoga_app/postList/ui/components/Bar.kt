package com.example.zemoga_app.postDetail.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.zemoga_app.postList.ui.PostViewModel

@Composable
fun Bar (navController: NavController, viewModel: PostViewModel){
    TopAppBar(
        title = { Text(
            text = "",
        ) },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = { }) {
                if (viewModel.post.favorite){
                    Icon(Icons.Filled.Star, contentDescription = null, tint = MaterialTheme.colors.primaryVariant)
                }else{
                    Icon(Icons.Filled.Star, contentDescription = null, tint = MaterialTheme.colors.secondary)
                }
            }
        }
    )
}