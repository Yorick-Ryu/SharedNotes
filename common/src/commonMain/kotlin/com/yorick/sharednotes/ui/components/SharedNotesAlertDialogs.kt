package com.yorick.sharednotes.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import com.yorick.sharednotes.ui.edit.EditViewModel

@Composable
expect fun SaveNoteAlertDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    onConfirm: () -> Unit = {},
)

@Composable
expect fun NewNoteAlertDialog(
    editViewModel: EditViewModel,
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    onConfirm: () -> Unit = {},
    onSubjectValueChange: (String) -> Unit,
    title: String,
    categories: List<String> = emptyList(),
    tags: List<String> = emptyList(),
    titleEditorFocus: FocusRequester
)