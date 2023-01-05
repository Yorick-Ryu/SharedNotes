package com.yorick.sharednotes.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.yorick.sharednotes.R

interface SharedNotesRouteDestination {
    val route: String
}

object SharedNotesRoute {
    const val NOTES = "Notes"
    const val CONTACTS = "Contacts"
    const val CATEGORIES = "Categories"
    const val TAGS = "Tags"
}

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

data class SharedNotesTopLevelDestination(
    override val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int
) : SharedNotesRouteDestination

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

val TOP_LEVEL_DESTINATIONS = listOf(
    SharedNotesTopLevelDestination(
        route = SharedNotesRoute.NOTES,
        selectedIcon = Icons.Default.Article,
        unselectedIcon = Icons.Default.Article,
        iconTextId = R.string.tab_notes
    ),
    SharedNotesTopLevelDestination(
        route = SharedNotesRoute.CONTACTS,
        selectedIcon = Icons.Default.Groups,
        unselectedIcon = Icons.Default.Groups,
        iconTextId = R.string.tab_contacts
    ),
    SharedNotesTopLevelDestination(
        route = SharedNotesRoute.CATEGORIES,
        selectedIcon = Icons.Default.Category,
        unselectedIcon = Icons.Default.Category,
        iconTextId = R.string.tab_categories
    ),
    SharedNotesTopLevelDestination(
        route = SharedNotesRoute.TAGS,
        selectedIcon = Icons.Default.LocalOffer,
        unselectedIcon = Icons.Default.LocalOffer,
        iconTextId = R.string.tab_tags
    ),
)