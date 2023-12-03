package org.creativeblogger.org.navigation

const val AUTHENTICATION_ROUTE = "authentication"
const val ROOT_ROUTE = "root"

sealed class Screen(val route: String) {
    object Loading: Screen(route = "loading_screen")
    object Login: Screen(route = "login_screen")
    object Home: Screen(route = "home_screen")
}