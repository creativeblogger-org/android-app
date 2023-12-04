package org.creativeblogger.org.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.creativeblogger.org.datastore.StoreToken
import org.creativeblogger.org.navigation.Screen

@Composable
fun LoadingScreen(
    navController: NavController
) {
    val tokenDatastore = StoreToken(LocalContext.current)
    val token = tokenDatastore.getToken.collectAsState(initial = null)

    if (token.value != null && token.value!!.isEmpty()) {
        navController.navigate(Screen.Login.route)
    } else if (token.value != null) {
        //TODO check if connected
        navController.navigate(Screen.Home.route)
    }

    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator(strokeWidth = 2.dp)
    }
}