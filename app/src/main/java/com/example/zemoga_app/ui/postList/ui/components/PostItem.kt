package com.example.zemoga_app.ui.postList.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zemoga_app.Screens.Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostItem (content: String, favorite: Boolean, navController: NavController){
    Column() {
        ListItem(
            text = {
                Row(
                    modifier = Modifier.fillMaxWidth().clickable {
                        navController.navigate(route = Screen.Detail.route)
                    },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.weight(1F)){
                        Badge (
                            backgroundColor = Color.Blue,
                            modifier = Modifier.width(8.dp).height(8.dp)
                        )
                    }
                    Text(content,
                        modifier = Modifier
                            .weight(15F)
                            .padding(10.dp).padding(end = 10.dp),
                        textAlign = TextAlign.Justify
                    )
                    Box( modifier = Modifier.weight(1F)){
                        if(favorite){
                            Icon(
                                Icons.Outlined.Star,
                                contentDescription = null,
                                tint = Color(0xFFFFDF00),
                            )
                        }
                    }
                }
            }
        )
        Divider()
    }
}