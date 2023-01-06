package com.yorick.sharednotes.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.ui.graphics.vector.ImageVector

object SharedNotesRoute {
    const val NOTES = "Notes"
    const val CONTACTS = "Contacts"
    const val CATEGORIES = "Categories"
    const val TAGS = "Tags"
}

interface SharedNotesRouteDestination {
    val route: String
}

data class SharedNotesTopLevelDestination(
    override val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconText: String
) : SharedNotesRouteDestination

val TOP_LEVEL_DESTINATIONS = listOf(
    SharedNotesTopLevelDestination(
        route = SharedNotesRoute.NOTES,
        selectedIcon = Icons.Default.Article,
        unselectedIcon = Icons.Default.Article,
        iconText = "Notes"
    ),
    SharedNotesTopLevelDestination(
        route = SharedNotesRoute.CONTACTS,
        selectedIcon = Icons.Default.Groups,
        unselectedIcon = Icons.Default.Groups,
        iconText = "Contacts"
    ),
    SharedNotesTopLevelDestination(
        route = SharedNotesRoute.CATEGORIES,
        selectedIcon = Icons.Default.Category,
        unselectedIcon = Icons.Default.Category,
        iconText = "Categories"
    ),
    SharedNotesTopLevelDestination(
        route = SharedNotesRoute.TAGS,
        selectedIcon = Icons.Default.LocalOffer,
        unselectedIcon = Icons.Default.LocalOffer,
        iconText = "Tags"
    ),
)