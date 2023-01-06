package com.yorick.sharednotes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SharedNotesTwoPane(
    modifier: Modifier = Modifier,
    first: @Composable () -> Unit,
    second: @Composable () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.weight(1f)) {
            first()
        }
        Column(modifier = Modifier.weight(1.6f)) {
            second()
        }
    }
}