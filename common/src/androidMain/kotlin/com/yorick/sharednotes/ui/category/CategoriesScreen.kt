package com.yorick.sharednotes.ui.category

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.window.layout.DisplayFeature
import com.google.accompanist.adaptive.HorizontalTwoPaneStrategy
import com.google.accompanist.adaptive.TwoPane
import com.yorick.sharednotes.ui.utils.SharedNotesContentType

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    categoriesUIState: CategoriesUIState,
    contentType: SharedNotesContentType,
    closeDetailScreen: () -> Unit,
    displayFeatures: List<DisplayFeature>,
    navigateToDetail: (Long, SharedNotesContentType) -> Unit,
) {
    LaunchedEffect(key1 = contentType) {
        if ((contentType == SharedNotesContentType.SINGLE_PANE) && !categoriesUIState.isDetailOnlyOpen) {
            closeDetailScreen()
        }
    }
    val categoryLazyListState = rememberLazyListState()
    val noteLazyListState = rememberLazyListState()

    if (contentType == SharedNotesContentType.DUAL_PANE) {
        TwoPane(
            first = {
                CategoriesListScreen(
                    modifier = modifier,
                    categories = categoriesUIState.categories,
                    categoryLazyListState = categoryLazyListState,
                    navigateToDetail = navigateToDetail
                )
            },
            second = {
                CategoryNotesScreen(
                    notes = categoriesUIState.categoryNotes,
                    noteLazyListState = noteLazyListState,
                    isFullScreen = false,
                    onBackPressed = closeDetailScreen,
                    navigateToDetail = { _, _ -> }
                )
            },
            strategy = HorizontalTwoPaneStrategy(splitFraction = 0.5f, gapWidth = 16.dp),
            displayFeatures = displayFeatures
        )
    } else {
        Box(modifier = modifier.fillMaxSize()) {
            CategoriesSinglePaneContent(
                modifier = Modifier.fillMaxSize(),
                categoriesUIState = categoriesUIState,
                categoryLazyListState = categoryLazyListState,
                noteLazyListState = noteLazyListState,
                closeDetailScreen = closeDetailScreen,
                navigateToDetail = navigateToDetail
            )
        }
    }
}

@Composable
fun CategoriesSinglePaneContent(
    modifier: Modifier = Modifier,
    categoriesUIState: CategoriesUIState,
    categoryLazyListState: LazyListState,
    noteLazyListState: LazyListState,
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long, SharedNotesContentType) -> Unit,
) {
    Crossfade(
        targetState = categoriesUIState.selectedCategory != null && categoriesUIState.isDetailOnlyOpen
    ) { screen ->
        when (screen) {
            true -> {
                BackHandler {
                    closeDetailScreen()
                }
                CategoryNotesScreen(
                    notes = categoriesUIState.categoryNotes,
                    noteLazyListState = noteLazyListState,
                    onBackPressed = closeDetailScreen,
                    navigateToDetail = { _, _ -> }
                )
            }
            false -> {
                CategoriesListScreen(
                    modifier = modifier,
                    categories = categoriesUIState.categories,
                    categoryLazyListState = categoryLazyListState,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}


