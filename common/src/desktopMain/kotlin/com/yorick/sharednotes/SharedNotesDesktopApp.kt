package com.yorick.sharednotes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.yorick.sharednotes.ui.navigation.*
import com.yorick.sharednotes.ui.utils.SharedNotesNavigationContentPosition
import com.yorick.sharednotes.ui.utils.SharedNotesNavigationType
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun SharedNotesDesktopApp() {

    val navigator = rememberNavigator()

    val navigationActions = remember(navigator) {
        NavigationActions(navigator)
    }

    val backStackEntry by navigator.currentEntry.collectAsState(null)
    val selectedDestination = backStackEntry?.route?.route ?: SharedNotesRoute.NOTES

    SharedNotesDesktopAppContent(
        navigator = navigator,
        navigationType = SharedNotesNavigationType.NAVIGATION_RAIL,
        selectedDestination = selectedDestination,
        navigateToTopLevelDestination = navigationActions::navigateTo
    )
}

@Composable
fun SharedNotesDesktopAppContent(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    navigationType: SharedNotesNavigationType,
    selectedDestination: String = SharedNotesRoute.NOTES,
    navigationContentPosition: SharedNotesNavigationContentPosition = SharedNotesNavigationContentPosition.TOP,
    navigateToTopLevelDestination: (SharedNotesTopLevelDestination) -> Unit
) {
    Row(modifier = modifier.fillMaxSize()) {
        AnimatedVisibility(visible = navigationType == SharedNotesNavigationType.NAVIGATION_RAIL) {
            SharedNotesNavigationRail(
                selectedDestination = selectedDestination,
                navigationContentPosition = navigationContentPosition,
                navigateToTopLevelDestination = navigateToTopLevelDestination,
                onDrawerClicked = { },
                addNote = { }
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            SharedNotesNavHost(
                navigator = navigator
            )
        }
    }
}