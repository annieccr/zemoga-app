package com.example.zemoga_app.Components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.zemoga_app.postList.ui.PostViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar (title: String, scope: CoroutineScope, drawerState: DrawerState, viewModel: PostViewModel){
    TopAppBar(
        title = { Text(
            text = title
        ) },
        navigationIcon = {
            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                Icon( Icons.Filled.Menu, contentDescription = null )
            }
        },
        actions = {
            IconButton(onClick = { viewModel.savePosts()}) {
                Icon( Icons.Filled.Refresh, contentDescription = null )
            }
        }
    )
}
