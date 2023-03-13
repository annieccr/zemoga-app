package com.example.zemoga_app

sealed class Screen(val route: String) {
    object Posts : Screen(route = "post_screen")
    object Splash : Screen(route = "splash")
    object Detail : Screen(route = "detail_screen/?id={id}") {
        fun createRoute(id: Int) = "detail_screen/?id=$id"
    }
}
