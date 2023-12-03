package org.creativeblogger.org.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
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

    Text("Loading...", color = MaterialTheme.colorScheme.onBackground)
}