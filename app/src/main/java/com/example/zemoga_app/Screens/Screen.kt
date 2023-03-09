package com.example.zemoga_app.Screens

sealed class Screen(val route: String){
    object Posts: Screen(route="post_screen")
    object Detail: Screen(route="detail_screen")
}
