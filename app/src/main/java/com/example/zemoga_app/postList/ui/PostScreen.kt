package com.example.zemoga_app.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zemoga_app.Components.TopBar
import com.example.zemoga_app.postList.ui.PostViewModel
import com.example.zemoga_app.postList.ui.components.Tab

@Composable
fun PostScreen (navController: NavController){
    Column() {
        TopBar("Posts", navController)
        Tab(navController, viewModel = PostViewModel())
    }

}

@Composable
@Preview(showBackground = true)
fun PostScreenPreview (){
    PostScreen(navController = rememberNavController())
}