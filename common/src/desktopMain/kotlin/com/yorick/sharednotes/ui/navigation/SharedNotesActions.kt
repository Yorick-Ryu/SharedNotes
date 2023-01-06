package com.yorick.sharednotes.ui.navigation

import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator

object EditDestination : SharedNotesRouteDestination {
    override val route: String = "Edit"
    const val noteId = "{noteId}?"
    val routeWithArg = "$route/$noteId"
}

class NavigationActions(private val navigator: Navigator) {

    fun navigateTo(destination: SharedNotesTopLevelDestination) {
        navigator.navigate(
            destination.route,
            NavOptions(
                launchSingleTop = true
            )
        )
    }
}