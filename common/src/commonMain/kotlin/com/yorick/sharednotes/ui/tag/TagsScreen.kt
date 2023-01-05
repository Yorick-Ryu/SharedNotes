package com.yorick.sharednotes.ui.tag

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yorick.sharednotes.ui.components.StaggeredGridBodyContent


@Composable
fun TagsGrid(
    tagsUIState: TagsUIState,
    modifier: Modifier = Modifier,
    onClickChip: (Long) -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        StaggeredGridBodyContent(
            modifier = Modifier.padding(horizontal = 20.dp),
            tags = tagsUIState.tags,
            rows = 4,
            onClickChip = onClickChip
        )
    }
}
