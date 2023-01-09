package com.yorick.sharednotes.ui.category

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
    val detailVisibility: Boolean =
        categoriesUIState.selectedCategory != null && categoriesUIState.isDetailOnlyOpen
    AnimatedVisibility(
        visible = !detailVisibility,
        enter = slideInHorizontally(initialOffsetX = { -it }),
        exit = slideOutHorizontally(targetOffsetX = { -it }) + fadeOut()
    ) {
        CategoriesListScreen(
            modifier = modifier,
            categories = categoriesUIState.categories,
            categoryLazyListState = categoryLazyListState,
            navigateToDetail = navigateToDetail
        )
    }
    AnimatedVisibility(
        visible = detailVisibility,
        enter = slideInHorizontally(initialOffsetX = { it }),
        exit = slideOutHorizontally(targetOffsetX = { -it })
    ) {
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
}