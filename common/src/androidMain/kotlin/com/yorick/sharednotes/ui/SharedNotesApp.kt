package com.yorick.sharednotes.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.window.layout.DisplayFeature
import androidx.window.layout.FoldingFeature
import com.yorick.sharednotes.ui.category.CategoriesViewModel
import com.yorick.sharednotes.ui.contact.ContactsViewModel
import com.yorick.sharednotes.ui.edit.EditViewModel
import com.yorick.sharednotes.ui.navigation.*
import com.yorick.sharednotes.ui.note.NotesViewModel
import com.yorick.sharednotes.ui.tag.TagsViewModel
import com.yorick.sharednotes.ui.utils.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SharedNotesApp(
    windowSize: WindowSizeClass,
    displayFeatures: List<DisplayFeature>,
    notesViewModel: NotesViewModel,
    contactsViewModel: ContactsViewModel,
    categoriesViewModel : CategoriesViewModel,
    tagsViewModel: TagsViewModel,
    editViewModel: EditViewModel
) {
    val navigationType: SharedNotesNavigationType
    val contentType: SharedNotesContentType
    val foldingFeature = displayFeatures.filterIsInstance<FoldingFeature>().firstOrNull()
    val foldingDevicePosture = when {
        isBookPosture(foldingFeature) ->
            DevicePosture.BookPosture(foldingFeature.bounds)

        isSeparating(foldingFeature) ->
            DevicePosture.Separating(foldingFeature.bounds, foldingFeature.orientation)

        else -> DevicePosture.NormalPosture
    }

    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            navigationType = SharedNotesNavigationType.BOTTOM_NAVIGATION
            contentType = SharedNotesContentType.SINGLE_PANE
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = SharedNotesNavigationType.NAVIGATION_RAIL
            contentType = if (foldingDevicePosture != DevicePosture.NormalPosture) {
                SharedNotesContentType.DUAL_PANE
            } else {
                SharedNotesContentType.SINGLE_PANE
            }
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = if (foldingDevicePosture is DevicePosture.BookPosture) {
                SharedNotesNavigationType.NAVIGATION_RAIL
            } else {
                SharedNotesNavigationType.PERMANENT_NAVIGATION_DRAWER
            }
            contentType = SharedNotesContentType.DUAL_PANE
        }
        else -> {
            navigationType = SharedNotesNavigationType.BOTTOM_NAVIGATION
            contentType = SharedNotesContentType.SINGLE_PANE
        }
    }

    val navigationContentPosition = when (windowSize.heightSizeClass) {
        WindowHeightSizeClass.Compact -> {
            SharedNotesNavigationContentPosition.TOP
        }
        WindowHeightSizeClass.Medium,
        WindowHeightSizeClass.Expanded -> {
            SharedNotesNavigationContentPosition.CENTER
        }
        else -> {
            SharedNotesNavigationContentPosition.TOP
        }
    }
    Column(
        modifier = Modifier.fillMaxSize().background(
            color = MaterialTheme.colorScheme.onSurface.copy(0.02F)
        ).statusBarsPadding()
    )
    {
        SharedNotesNavigationWrapper(
            navigationType = navigationType,
            contentType = contentType,
            displayFeatures = displayFeatures,
            navigationContentPosition = navigationContentPosition,
            notesViewModel = notesViewModel,
            contactsViewModel = contactsViewModel,
            categoriesViewModel = categoriesViewModel,
            tagsViewModel = tagsViewModel,
            editViewModel = editViewModel
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharedNotesNavigationWrapper(
    navigationType: SharedNotesNavigationType,
    contentType: SharedNotesContentType,
    displayFeatures: List<DisplayFeature>,
    navigationContentPosition: SharedNotesNavigationContentPosition,
    notesViewModel: NotesViewModel,
    contactsViewModel: ContactsViewModel,
    categoriesViewModel :CategoriesViewModel,
    tagsViewModel: TagsViewModel,
    editViewModel: EditViewModel
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        NavigationActions(navController)
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val selectedDestination = navBackStackEntry?.destination?.route ?: SharedNotesRoute.NOTES
    val sharedNotesBottomVisible =
        (navigationType == SharedNotesNavigationType.BOTTOM_NAVIGATION) && (navController.currentDestination?.route != EditDestination.routeWithArg)
    val addNote = {
        navController.navigate(EditDestination.route)
        editViewModel.onInit()
    }
    if (navigationType == SharedNotesNavigationType.PERMANENT_NAVIGATION_DRAWER) {
        PermanentNavigationDrawer(drawerContent = {
            PermanentNavigationDrawerContent(
                selectedDestination = selectedDestination,
                navigationContentPosition = navigationContentPosition,
                navigateToTopLevelDestination = navigationActions::navigateTo,
                addNote = addNote,
            )
        }) {
            SharedNotesAppContent(
                navigationType = navigationType,
                navController = navController,
                selectedDestination = selectedDestination,
                contentType = contentType,
                displayFeatures = displayFeatures,
                navigationContentPosition = navigationContentPosition,
                notesViewModel = notesViewModel,
                contactsViewModel = contactsViewModel,
                categoriesViewModel = categoriesViewModel,
                tagsViewModel = tagsViewModel,
                editViewModel = editViewModel,
                navigateToTopLevelDestination = navigationActions::navigateTo,
                addNote = addNote,
                scope = scope
            )
        }
    } else {
        ModalNavigationDrawer(
            drawerContent = {
                ModalNavigationDrawerContent(
                    selectedDestination = selectedDestination,
                    navigationContentPosition = navigationContentPosition,
                    navigateToTopLevelDestination = navigationActions::navigateTo,
                    onDrawerClicked = {
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    addNote = addNote,
                )
            },
            drawerState = drawerState
        ) {
            SharedNotesAppContent(
                navigationType = navigationType,
                navController = navController,
                selectedDestination = selectedDestination,
                contentType = contentType,
                notesViewModel = notesViewModel,
                contactsViewModel = contactsViewModel,
                categoriesViewModel = categoriesViewModel,
                tagsViewModel = tagsViewModel,
                editViewModel = editViewModel,
                displayFeatures = displayFeatures,
                navigationContentPosition = navigationContentPosition,
                navigateToTopLevelDestination = navigationActions::navigateTo,
                addNote = addNote,
                sharedNotesBottomVisible = sharedNotesBottomVisible,
                scope = scope
            ) {
                scope.launch {
                    drawerState.open()
                }
            }
        }
    }
}

@Composable
fun SharedNotesAppContent(
    modifier: Modifier = Modifier,
    navigationType: SharedNotesNavigationType,
    navController: NavHostController,
    selectedDestination: String,
    contentType: SharedNotesContentType,
    displayFeatures: List<DisplayFeature>,
    navigationContentPosition: SharedNotesNavigationContentPosition,
    notesViewModel: NotesViewModel,
    contactsViewModel: ContactsViewModel,
    categoriesViewModel: CategoriesViewModel,
    tagsViewModel: TagsViewModel,
    editViewModel: EditViewModel,
    navigateToTopLevelDestination: (SharedNotesTopLevelDestination) -> Unit,
    sharedNotesBottomVisible: Boolean = false,
    addNote: () -> Unit,
    scope: CoroutineScope,
    onDrawerClicked: () -> Unit = {},
) {
    Row(modifier = modifier.fillMaxSize()) {
        AnimatedVisibility(visible = navigationType == SharedNotesNavigationType.NAVIGATION_RAIL) {
            SharedNotesNavigationRail(
                selectedDestination = selectedDestination,
                navigationContentPosition = navigationContentPosition,
                navigateToTopLevelDestination = navigateToTopLevelDestination,
                onDrawerClicked = onDrawerClicked,
                addNote = addNote
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            SharedNotesNavHost(
                navController = navController,
                contentType = contentType,
                displayFeatures = displayFeatures,
                notesViewModel = notesViewModel,
                contactsViewModel = contactsViewModel,
                categoriesViewModel = categoriesViewModel,
                tagsViewModel = tagsViewModel,
                editViewModel = editViewModel,
                navigationType = navigationType,
                modifier = Modifier.weight(1f),
                scope = scope
            )
            AnimatedVisibility(visible = sharedNotesBottomVisible) {
                SharedNotesBottomNavigationBar(
                    selectedDestination = selectedDestination,
                    navigateToTopLevelDestination = navigateToTopLevelDestination
                )
            }
        }
    }
}