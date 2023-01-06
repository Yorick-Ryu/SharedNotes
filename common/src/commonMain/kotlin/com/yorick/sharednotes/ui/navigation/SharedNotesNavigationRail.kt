package com.yorick.sharednotes.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.NoteAdd
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import com.yorick.sharednotes.ui.utils.SharedNotesNavigationContentPosition

@Composable
fun SharedNotesNavigationRail(
    selectedDestination: String,
    navigationContentPosition: SharedNotesNavigationContentPosition,
    navigateToTopLevelDestination: (SharedNotesTopLevelDestination) -> Unit,
    onDrawerClicked: () -> Unit = {},
    addNote: () -> Unit
) {
    NavigationRail(
        modifier = Modifier.fillMaxHeight(),
        containerColor = MaterialTheme.colorScheme.inverseOnSurface
    ) {
        Layout(
            modifier = Modifier.widthIn(max = 80.dp),
            content = {
                Column(
                    modifier = Modifier
                        .layoutId(LayoutType.HEADER),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    NavigationRailItem(
                        selected = false,
                        onClick = onDrawerClicked,
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Navigation Drawer"
                            )
                        }
                    )
                    FloatingActionButton(
                        onClick = addNote,
                        modifier = Modifier.padding(top = 0.dp, bottom = 0.dp),
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.NoteAdd,
                            contentDescription = "Edit",
                        )
                    }
                    Spacer(Modifier.height(8.dp)) // NavigationRailHeaderPadding
                    Spacer(Modifier.height(4.dp)) // NavigationRailVerticalPadding
                }
                Column(
                    modifier = Modifier
                        .layoutId(LayoutType.CONTENT)
                        .verticalScroll(state = rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    TOP_LEVEL_DESTINATIONS.forEach { sharedNotesDestination ->
                        NavigationRailItem(
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
            },
            measurePolicy = getMeasurePolicy(navigationContentPosition)
        )
    }
}

fun getMeasurePolicy(
    navigationContentPosition: SharedNotesNavigationContentPosition,
): MeasurePolicy {
    return MeasurePolicy { measurables, constraints ->
        lateinit var headerMeasurable: Measurable
        lateinit var contentMeasurable: Measurable
        measurables.forEach {
            when (it.layoutId) {
                LayoutType.HEADER -> headerMeasurable = it
                LayoutType.CONTENT -> contentMeasurable = it
                else -> error("Unknown layoutId encountered!")
            }
        }

        val headerPlaceable = headerMeasurable.measure(constraints)
        val contentPlaceable = contentMeasurable.measure(
            constraints.offset(vertical = -headerPlaceable.height)
        )
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Place the header, this goes at the top
            headerPlaceable.placeRelative(0, 0)

            // Determine how much space is not taken up by the content
            val nonContentVerticalSpace = constraints.maxHeight - contentPlaceable.height

            val contentPlaceableY = when (navigationContentPosition) {
                // Figure out the place we want to place the content, with respect to the
                // parent (ignoring the header for now)
                SharedNotesNavigationContentPosition.TOP -> 0
                SharedNotesNavigationContentPosition.CENTER -> nonContentVerticalSpace / 2
            }
                // And finally, make sure we don't overlap with the header.
                .coerceAtLeast(headerPlaceable.height)

            contentPlaceable.placeRelative(0, contentPlaceableY)
        }
    }
}

enum class LayoutType {
    HEADER, CONTENT
}