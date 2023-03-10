package com.example.zemoga_app.postDetail.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.ListItem
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Comment (comment:String){
    Column() {
        ListItem(
            text = { Text(comment) }
        )
        Divider()
    }
}