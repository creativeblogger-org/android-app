package org.creativeblogger.org.navigation.nav_graph

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import org.creativeblogger.org.navigation.AUTHENTICATION_ROUTE
import org.creativeblogger.org.navigation.Screen
import org.creativeblogger.org.screens.LoadingScreen
import org.creativeblogger.org.screens.LoginScreen
import org.creativeblogger.org.viewmodel.LoginViewModel

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Loading.route, route = AUTHENTICATION_ROUTE) {
        composable(Screen.Loading.route) {
            LoadingScreen(navController = navController)
        }
        composable(Screen.Login.route) {
            val loginViewModel = hiltView<LoginViewModel>()
            LoginScreen(loginViewModel)
        }
        //20:48
    }
}