package com.example.zemoga_app.ui.postList.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zemoga_app.ui.postList.ui.PostViewModel

@Composable
fun Tab (navController: NavController, viewModel: PostViewModel) {
    val tabSelected:Int by viewModel.tabSelected.observeAsState(initial = 0)
    val titles = listOf("ALL", "FAVORITES")
    Column {
        TabRow(
            selectedTabIndex = tabSelected,
            backgroundColor = Color(0xFF37b24d),
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title, color = Color.White,) },
                    selected = tabSelected == index,
                    onClick = { viewModel.setTab(index) },
                    selectedContentColor = Color(0xFF12ea1d),
                )
            }
        }

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
}