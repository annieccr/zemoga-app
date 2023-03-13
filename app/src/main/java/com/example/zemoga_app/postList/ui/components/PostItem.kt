package com.example.zemoga_app.postList.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zemoga_app.postList.ui.model.room.Post
import com.example.zemoga_app.postList.ui.PostViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostItem(content: Post, goToDetail: (Int) -> Unit, viewModel: PostViewModel) {
    Column() {
        ListItem(
            text = {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.weight(1F)) {
                        Badge(
                            backgroundColor = Color.Blue,
                            modifier = Modifier
                                .width(8.dp)
                                .height(8.dp)
                        )
                    }
                    Box(modifier = Modifier
                        .weight(15F)
                        .clickable {
                            goToDetail(content.id)
                        }) {
                        Text(
                            content.title.uppercase(),
                            modifier = Modifier
                                .padding(20.dp)
                                .padding(end = 10.dp),
                            textAlign = TextAlign.Left,
                            fontSize = 15.sp,
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(2F)
                    ) {
                        IconButton(onClick = {
                            viewModel.updatePost(
                                !content.favorite,
                                content.id
                            )
                        }) {
                            if (content.favorite) {
                                Icon(
                                    Icons.Filled.Star,
                                    contentDescription = null,
                                    tint = MaterialTheme.colors.primaryVariant,
                                    modifier = Modifier.size(30.dp)
                                )
                            } else {
                                Icon(
                                    Icons.Outlined.Star,
                                    contentDescription = null,
                                    tint = MaterialTheme.colors.secondary,
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        Divider()
    }
}