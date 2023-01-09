package com.yorick.sharednotes.ui.edit

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun EditContent(
    modifier: Modifier = Modifier,
    text: String,
    onBodyValueChange: (String) -> Unit = {},
    onClickedTextButton: (char: String) -> Unit = { _ -> },
    stateVertical: ScrollState = rememberScrollState(),
) {
    val textEditorFocus = remember { FocusRequester() }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = MaterialTheme.shapes.large
            )
    ) {
        BasicTextField(
            modifier = Modifier
                .fillMaxSize()
                .focusRequester(textEditorFocus)
                .weight(1f)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .scrollable(
                    orientation = Orientation.Horizontal,
                    state = stateVertical
                ),
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
        EditToolsBar(
            modifier = Modifier.padding(5.dp),
            onClickedTextButton = onClickedTextButton
        )
    }
    SideEffect {
        textEditorFocus.requestFocus()
    }
}