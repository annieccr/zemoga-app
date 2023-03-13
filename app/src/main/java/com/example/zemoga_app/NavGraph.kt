package com.example.zemoga_app

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.zemoga_app.Screens.PostScreen
import com.example.zemoga_app.postDetail.ui.DetailPostScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(
            route = Screen.Splash.route
        ) {
            SplashScreen(navController = navController)
        }
        composable(
            route = Screen.Posts.route
        ) {
            PostScreen(
                viewModel = hiltViewModel(),
                goToDetail = { newRoute ->
                    navController.navigate(
                        Screen.Detail.createRoute(newRoute)
                    )
                })
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("id") { defaultValue = 404 })
        ) { navBackStackEntry ->
            var id = navBackStackEntry.arguments?.getInt("id")
            requireNotNull(id)
            DetailPostScreen(navController = navController, viewModel = hiltViewModel(), id)
        }
    }
}