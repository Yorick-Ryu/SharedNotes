package com.yorick.sharednotes.ui.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Link
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditToolsBar(
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