package com.example.zemoga_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.zemoga_app.Screens.PostScreen
import com.example.zemoga_app.postDetail.ui.DetailPostScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
){
    NavHost(navController = navController, startDestination = Screen.Posts.route){
        composable(
            route = Screen.Posts.route
        ){
            PostScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route
        ){
            DetailPostScreen(navController = navController)
        }
    }
}