package com.yorick.sharednotes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SaveNoteAlertDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    onConfirm: () -> Unit = {},
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        title = { Text(text = "Not saved") },
        text = { Text(text = "Do you really want to exit the Editor?") },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = "Cancel")
            }
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "Confirm")
            }
        },
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewNoteAlertDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    onConfirm: () -> Unit = {},
    onSubjectValueChange: (String) -> Unit,
    title: String,
    categories: List<String> = emptyList(),
    tags: List<String> = emptyList(),
    titleEditorFocus: FocusRequester
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = "Note Info")
        },
        text = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//                OutlinedTextField(
//                    modifier = Modifier
//                        .padding(vertical = 10.dp)
//                        .focusRequester(titleEditorFocus),
//                    value = title,
//                    onValueChange = onSubjectValueChange,
//                    label = { Text(text = "Note Title") },
//                    singleLine = true
//                )
                SharedNotesDropDownMenu(
                    menuList = categories,
                    label = "Categories"
                )
                SharedNotesDropDownMenu(
                    menuList = tags,
                    label = "Tags"
                )
            }
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "OK")
            }
        },
    )
}