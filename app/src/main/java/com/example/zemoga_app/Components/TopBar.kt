package com.example.zemoga_app.Components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun TopBar (title: String, navController: NavController){
    TopAppBar(
        backgroundColor = Color(0xFF37b24d),
        title = { Text(
            text = title,
            color = Color.White
        ) },
        navigationIcon = {
            if(title == ""){
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)
                }
            }else{
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Menu, contentDescription = null, tint = Color.White)
                }
            }
        },
        actions = {
            if(title == ""){
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Refresh, contentDescription = null, tint = Color.White)
                }
            }else{
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Star, contentDescription = null, tint = Color.White)
                }
            }
        }
    )
}
