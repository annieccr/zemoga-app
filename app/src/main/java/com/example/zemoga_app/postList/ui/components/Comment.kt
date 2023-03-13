package com.example.zemoga_app.postDetail.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.ListItem
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Comment (comment:String){
    Column() {
        ListItem(
            text = { Text(comment, textAlign = TextAlign.Justify) },
            modifier = Modifier.padding(vertical = 10.dp),
        )
        Divider()
    }
}