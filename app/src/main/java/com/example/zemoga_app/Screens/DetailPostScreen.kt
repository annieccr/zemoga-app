package com.example.zemoga_app.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zemoga_app.ui.postDetail.ui.components.Comment

@Composable
fun DetailPostScreen (navController : NavController){
    Column() {
        TopBarDetail(navController)
        Box(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        ) {
            Column(
                Modifier
                    .padding(20.dp).fillMaxHeight(1F)
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
                    text = "It is a long established fact that a reader will be distracted by the readable content It is a long established fact that a reader will be distracted by the readable content It is a long established fact that a reader will be distracted by the readable content It is a long established fact that a reader will be distracted by the readable content ",
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
                        text = "Name - name",
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
                        text = "Email - email",
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
                        text = "Phone - phone",
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
                        text = "Website - site",
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
                        Comment("This is a comment")
                        Comment("This is a comment")
                        Comment("This is a comment")
                        Comment("This is a comment")
                        Comment("This is a comment")
                        Comment("This is a comment")
                        Comment("This is a comment")
                        Comment("This is a comment")
                        Comment("This is a comment")
                        Comment("This is a comment")
                        Comment("This is a comment")
                        Comment("This is a comment")


                    }
                }

            }

        }
    }

}

@Composable
fun TopBarDetail (navController: NavController){
    TopAppBar(
        backgroundColor = Color(0xFF37b24d),
        title = { Text(
            text = "",
            color = Color.White
        ) },
        navigationIcon = {
            IconButton(onClick = {navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Outlined.Star, contentDescription = null, tint = Color.White)
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun DetailPostScreenPreview (){
    DetailPostScreen(navController = rememberNavController())
}