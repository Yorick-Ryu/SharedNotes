package com.yorick.sharednotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
actual fun SharedNotesDropDownMenu(
    modifier: Modifier,
    label: String,
    menuList: List<String>,
) {
    val focus = remember { FocusRequester() }
    var expanded by remember {
        mutableStateOf(false)
    }
    var category by remember {
        mutableStateOf(menuList.first())
    }
    Row(
        modifier = modifier.padding(vertical = 10.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.focusRequester(focus),
            value = category,
            onValueChange = {
                category = it
            },
            singleLine = true,
            enabled = true,
            trailingIcon = {
                IconButton(onClick = {
                    expanded = true
                    focus.requestFocus()
                }) {
                    Icon(
                        if (expanded) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
                        contentDescription = "expend button"
                    )
                }
            },
            label = {
                Text(text = label)
            }
        )
        DropdownMenu(
            modifier = Modifier.background(
                color = MaterialTheme.colorScheme.surfaceVariant
            ).border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.small
            ),
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(0.dp, 0.dp),
        ) {
            for (menu in menuList) {
                DropdownMenuItem(
                    content = { Text(text = menu) },
                    onClick = {
                        category = menu
                        expanded = false
                    },
                )
            }
        }
    }
}