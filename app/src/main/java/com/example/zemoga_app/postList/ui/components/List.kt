package com.example.zemoga_app.postList.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun List (tabSelected: Int, navController: NavController){
    if (tabSelected == 0){
        Box(modifier = Modifier.verticalScroll(rememberScrollState())){
            Column(modifier = Modifier.fillMaxSize()) {
                PostItem("Post 1", true, navController)
                PostItem("Post 3", false, navController)

            }
        }
        Box(modifier = Modifier.fillMaxSize()){
            FloatingActionButton(
                onClick = { /*do something*/ },
                backgroundColor = Color.Red,
                elevation = FloatingActionButtonDefaults.elevation(10.dp),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(all = 16.dp)
            ) {
                Icon(Icons.Filled.Delete, contentDescription = null, tint = Color.White)
            }
        }
    }else{
        Box(modifier = Modifier.verticalScroll(rememberScrollState())){
            Column() {
                PostItem("Post 2", false, navController)
            }
        }
    }
}