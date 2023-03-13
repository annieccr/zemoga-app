package com.example.zemoga_app.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.zemoga_app.postList.ui.PostViewModel

@Composable
fun Alert(viewModel: PostViewModel) {
    AlertDialog(
        onDismissRequest = {
            viewModel.closeDialog()
        },
        title = {
            Text(text = "Are you sure you want to delete all posts?", textAlign = TextAlign.Center)
        },
        buttons = {
            Row(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Button(
                    onClick = { viewModel.closeDialog() },
                ) {
                    Text("Cancel")
                }
                Button(
                    onClick = { viewModel.deleteAllPosts() },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                ) {
                    Text("Delete", color = Color.White)
                }
            }
        }
    )
}