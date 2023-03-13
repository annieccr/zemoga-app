package com.example.zemoga_app.postList.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.zemoga_app.postList.ui.PostViewModel

@Composable
fun Tab(viewModel: PostViewModel, tabSelected: Int) {
    val titles = listOf("ALL", "FAVORITES")
    Column {
        TabRow(
            selectedTabIndex = tabSelected,
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title, color = Color.White, fontSize = 16.sp) },
                    selected = tabSelected == index,
                    onClick = { viewModel.setTab(index) },
                    selectedContentColor = Color(0xFF12ea1d),
                )
            }
        }
    }
}