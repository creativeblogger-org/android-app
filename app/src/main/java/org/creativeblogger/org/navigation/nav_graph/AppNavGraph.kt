package org.creativeblogger.org.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.creativeblogger.org.navigation.AUTHENTICATION_ROUTE
import org.creativeblogger.org.navigation.ROOT_ROUTE
import org.creativeblogger.org.navigation.Screen
import org.creativeblogger.org.screens.HomeScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AUTHENTICATION_ROUTE, route = ROOT_ROUTE) {
        authNavGraph(navController)

        composable(Screen.Home.route) {
            HomeScreen()
        }
    }
}