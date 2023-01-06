package com.yorick.sharednotes.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument

object EditDestination : SharedNotesRouteDestination {
    override val route: String = "Edit"
    const val noteId = "noteId"
    val routeWithArg = "${route}?${noteId}={${noteId}}"
    val arguments = listOf( // 让此 composable 知道它应该接受实参
        navArgument(noteId) {
            type = NavType.LongType
            defaultValue = -1L
        }
    )
}

class NavigationActions(private val navController: NavHostController) {

    fun navigateTo(destination: SharedNotesTopLevelDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

