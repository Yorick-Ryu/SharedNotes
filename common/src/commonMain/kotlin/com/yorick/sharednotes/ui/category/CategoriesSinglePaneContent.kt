package com.yorick.sharednotes.ui.category

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yorick.sharednotes.ui.utils.SharedNotesContentType
import moe.tlaster.precompose.navigation.BackHandler

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