package com.yorick.sharednotes.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MenuOpen
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.yorick.sharednotes.R
import com.yorick.sharednotes.ui.utils.SharedNotesNavigationContentPosition

@Composable
fun SharedNotesBottomNavigationBar(
    selectedDestination: String,
    navigateToTopLevelDestination: (SharedNotesTopLevelDestination) -> Unit
) {
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        TOP_LEVEL_DESTINATIONS.forEach { sharedNotesDestination ->
            NavigationBarItem(
                selected = selectedDestination == sharedNotesDestination.route,
                onClick = { navigateToTopLevelDestination(sharedNotesDestination) },
                icon = {
                    Icon(
                        imageVector = sharedNotesDestination.selectedIcon,
                        contentDescription = sharedNotesDestination.iconText
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PermanentNavigationDrawerContent(
    selectedDestination: String,
    addNote: () -> Unit,
    navigationContentPosition: SharedNotesNavigationContentPosition,
    navigateToTopLevelDestination: (SharedNotesTopLevelDestination) -> Unit,
) {
    PermanentDrawerSheet(modifier = Modifier.sizeIn(minWidth = 200.dp, maxWidth = 300.dp)) {
        Layout(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .padding(),
            content = {
                Column(
                    modifier = Modifier.layoutId(LayoutType.HEADER),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = stringResource(id = R.string.app_name).uppercase(),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    MyExtendedFloatingActionButton(
                        modifier = Modifier,
                        addNote = addNote
                    )
                }
                Column(
                    modifier = Modifier
                        .layoutId(LayoutType.CONTENT)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    TOP_LEVEL_DESTINATIONS.forEach { sharedNotesDestination ->
                        SharedNotesNavigationDrawerItem(
                            selectedDestination = selectedDestination,
                            sharedNotesDestination = sharedNotesDestination,
                            navigateToTopLevelDestination = navigateToTopLevelDestination
                        )
                    }
                }
            },
            measurePolicy = getMeasurePolicy(navigationContentPosition)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalNavigationDrawerContent(
    selectedDestination: String,
    navigationContentPosition: SharedNotesNavigationContentPosition,
    navigateToTopLevelDestination: (SharedNotesTopLevelDestination) -> Unit,
    onDrawerClicked: () -> Unit = {},
    addNote: () -> Unit,
) {
    ModalDrawerSheet {
        Layout(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .padding(16.dp),
            content = {
                Column(
                    modifier = Modifier.layoutId(LayoutType.HEADER),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.app_name).uppercase(),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        IconButton(onClick = onDrawerClicked) {
                            Icon(
                                imageVector = Icons.Default.MenuOpen,
                                contentDescription = stringResource(id = R.string.navigation_drawer)
                            )
                        }
                    }
                    MyExtendedFloatingActionButton(
                        modifier = Modifier,
                        addNote = addNote
                    )
                }

                Column(
                    modifier = Modifier
                        .layoutId(LayoutType.CONTENT)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    TOP_LEVEL_DESTINATIONS.forEach { sharedNotesDestination ->
                        SharedNotesNavigationDrawerItem(
                            selectedDestination = selectedDestination,
                            sharedNotesDestination = sharedNotesDestination,
                            navigateToTopLevelDestination = navigateToTopLevelDestination
                        )
                    }
                }
            },
            measurePolicy = getMeasurePolicy(navigationContentPosition)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharedNotesNavigationDrawerItem(
    selectedDestination: String,
    sharedNotesDestination: SharedNotesTopLevelDestination,
    navigateToTopLevelDestination: (SharedNotesTopLevelDestination) -> Unit,
) {
    NavigationDrawerItem(
        selected = selectedDestination == sharedNotesDestination.route,
        label = {
            Text(
                text = sharedNotesDestination.iconText,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        },
        icon = {
            Icon(
                imageVector = sharedNotesDestination.selectedIcon,
                contentDescription = sharedNotesDestination.iconText
            )
        },
        colors = NavigationDrawerItemDefaults.colors(
            unselectedContainerColor = Color.Transparent
        ),
        onClick = { navigateToTopLevelDestination(sharedNotesDestination) }
    )
}

@Composable
fun MyExtendedFloatingActionButton(
    modifier: Modifier = Modifier,
    addNote: () -> Unit
) {
    ExtendedFloatingActionButton(
        onClick = addNote,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 40.dp),
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
    ) {
        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = stringResource(id = R.string.edit),
            modifier = Modifier.size(18.dp)
        )
        Text(
            text = stringResource(id = R.string.new_notes),
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
    }
}





