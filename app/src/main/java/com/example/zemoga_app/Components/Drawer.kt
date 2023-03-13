package com.example.zemoga_app.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.zemoga_app.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.material.ListItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Drawer(scope: CoroutineScope, drawerState: DrawerState) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(350.dp)
    ) {
        Column(
            modifier = Modifier.padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(
                        BorderStroke(1.dp, Color.LightGray),
                        CircleShape
                    )
            )
            Text(text = "Nombre completo", fontWeight = FontWeight.Bold)
            Text(text = "email.email@gmail.com", fontWeight = FontWeight.Light)
        }
        Divider()
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            ListItem(
                text = { Text("Favorites") },
                icon = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = null,
                    )
                }
            )
            ListItem(
                text = { Text("Favorites") },
                icon = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = null,
                    )
                }
            )
            ListItem(
                text = { Text("Favorites") },
                icon = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = null,
                    )
                }
            )
        }
        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            onClick = { scope.launch { drawerState.close() } },
            content = { Text("Close Drawer") }
        )
    }
}