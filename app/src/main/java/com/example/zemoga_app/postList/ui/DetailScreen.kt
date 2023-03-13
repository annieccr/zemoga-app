package com.example.zemoga_app.postDetail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zemoga_app.postDetail.ui.components.Bar
import com.example.zemoga_app.postDetail.ui.components.Comment
import com.example.zemoga_app.postList.ui.PostViewModel

@Composable
fun DetailPostScreen (navController : NavController, viewModel: PostViewModel, id:Int){
    LaunchedEffect(Unit){
        viewModel.getPost(id)
    }
    Column() {
        Bar(navController, viewModel)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                Modifier
                    .padding(20.dp)
                    .fillMaxHeight(1F)
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    text = "Description",
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
                Text(
                    textAlign = TextAlign.Justify,
                    text = viewModel.post.body.toString(),
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    text = "User",
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
                Row() {
                    Text(
                        text = "Name: ",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                    Text(
                        text = viewModel.user.name.toString(),
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                }
                Row() {
                    Text(
                        text = "Email: ",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                    Text(
                        text = viewModel.user.email.toString(),
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                }
                Row() {
                    Text(
                        text = "Phone: ",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                    Text(
                        text = viewModel.user.phone.toString(),
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                }
                Row() {
                    Text(
                        text = "Website: ",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                    Text(
                        text = viewModel.user.website.toString(),
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth()
                ){
                    Column() {
                        Text(
                            text = "COMMENTS",
                            modifier = Modifier
                                .background(Color.Gray)
                                .fillMaxWidth()
                                .padding(5.dp)
                        )
                        for (comment in viewModel.comments){
                            Comment(comment.body)
                        }
                    }
                }

            }
        }
    }

}

