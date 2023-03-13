package com.example.zemoga_app.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zemoga_app.Components.Alert
import com.example.zemoga_app.Components.Drawer
import com.example.zemoga_app.Components.Loading
import com.example.zemoga_app.Components.TopBar
import com.example.zemoga_app.postList.ui.PostViewModel
import com.example.zemoga_app.postList.ui.components.Tab
import com.example.zemoga_app.postList.ui.components.List

@Composable
fun PostScreen (navController: NavController, viewModel: PostViewModel = hiltViewModel(), goToDetail: (Int) -> Unit){
    val tabSelected:Int by viewModel.tabSelected.observeAsState(initial = 0)
    val posts by viewModel.posts.observeAsState(arrayListOf())
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Drawer(scope, drawerState)
        },
        content = {
            Column() {
                TopBar("Posts", scope, drawerState, viewModel)
                Tab(viewModel, tabSelected)
                if (viewModel.isLoading){
                    Loading()
                }else{
                    List(tabSelected, goToDetail, viewModel, posts)
                }
            }
            if(tabSelected == 0 && viewModel.posts.value?.isNotEmpty() == true){
                Box(modifier = Modifier.fillMaxSize()){
                    FloatingActionButton(
                        onClick = { viewModel.openDialog()},
                        backgroundColor = Color.Red,
                        elevation = FloatingActionButtonDefaults.elevation(10.dp),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(all = 16.dp)
                    ) {
                        Icon(Icons.Filled.Delete, contentDescription = null, tint = Color.White)
                    }
                }
            }
            if (viewModel.dialog) {
                Alert(viewModel = viewModel)
            }
        }
    )
}


