package com.yorick.sharednotes.ui.edit

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.yorick.sharednotes.ui.components.NewNoteAlertDialog
import com.yorick.sharednotes.ui.components.SaveNoteAlertDialog
import com.yorick.sharednotes.ui.components.SharedNotesAppBars
import com.yorick.sharednotes.ui.note.NoteContent

@Composable
fun EditScreen(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    categories: List<String> = emptyList(),
    tags: List<String> = emptyList(),
    onBodyValueChange: (String) -> Unit = {},
    onSubjectValueChange: (String) -> Unit = {},
    isEditModeEnabled: Boolean = true,
    isOpenNoteInfoDialog: Boolean = false,
    isOpenSaveDialog: Boolean = false,
    titleEditorFocus: FocusRequester = remember { FocusRequester() },
    onModeChanged: () -> Unit = {},
    onSavedNote: () -> Unit = {},
    onDismissRequest: () -> Unit = {},
    onDismissSaveRequest: () -> Unit = {},
    onConfirm: () -> Unit = {},
    onConfirmClose: () -> Unit = {},
    onClickedTextButton: (char: String) -> Unit = { _ -> },
    onBackPressed: () -> Unit = {},
    onClickTitle: () -> Unit = {},
) {
    if (isOpenNoteInfoDialog) {
        NewNoteAlertDialog(
            modifier = Modifier,
            onDismissRequest = onDismissRequest,
            onConfirm = onConfirm,
            title = title,
            onSubjectValueChange = onSubjectValueChange,
            titleEditorFocus = titleEditorFocus,
            categories = categories,
            tags = tags
        )
    }
    if (isOpenSaveDialog) {
        SaveNoteAlertDialog(
            modifier = Modifier,
            onDismissRequest = onDismissSaveRequest,
            onConfirm = onConfirmClose,
        )
    }
    Column(modifier = modifier) {

        SharedNotesAppBars(
            title = title,
            isFullScreen = true,
            onBackPressed = onBackPressed,
            onClickTitle = onClickTitle
        ) {
            Row {
                IconButton(onClick = onModeChanged) {
                    Icon(
                        imageVector = if (isEditModeEnabled) Icons.Default.Visibility else Icons.Default.Edit,
                        contentDescription = "Preview",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                IconButton(onClick = onSavedNote) {
                    Icon(
                        imageVector = Icons.Default.Save,
                        contentDescription = "preview",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
        if (isEditModeEnabled) {
            EditContent(
                text = text,
                onBodyValueChange = onBodyValueChange,
                onClickedTextButton = onClickedTextButton
            )
        } else {
            NoteContent(noteBody = text)
        }
    }
}

@Composable
fun EditContent(
    modifier: Modifier = Modifier,
    text: String,
    onBodyValueChange: (String) -> Unit = {},
    onClickedTextButton: (char: String) -> Unit = { _ -> }
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        BasicTextField(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(horizontal = 20.dp),
            value = text,
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            onValueChange = onBodyValueChange,
        )
        ToolsBar(
            modifier = Modifier.padding(5.dp),
            onClickedTextButton = onClickedTextButton
        )
    }
}

@Composable
fun ToolsBar(
    modifier: Modifier = Modifier,
    onClickedTextButton: (char: String) -> Unit = { _ -> }
) {
    val toolChars = listOf(
        "#",
        "+",
        "-",
        "*",
        "/",
        "`"
    )
    val icons = listOf(
        Icons.Default.Image,
        Icons.Default.Code,
        Icons.Default.Link,
    )
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (char in toolChars) {
            TextButton(
                modifier = Modifier.width(40.dp),
                onClick = { onClickedTextButton(char) }
            ) {
                Text(
                    text = char,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
        for (icon in icons) {
            IconButton(
                onClick = { /*TODO*/ },
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = ""
                )
            }
        }
    }
}