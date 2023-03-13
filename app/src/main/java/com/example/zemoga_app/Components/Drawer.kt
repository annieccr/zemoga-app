package com.example.zemoga_app.Components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Drawer (scope: CoroutineScope, drawerState: DrawerState){
    Column() {
        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            onClick = { scope.launch { drawerState.close() } },
            content = { Text("Close Drawer") }
        )
    }
}