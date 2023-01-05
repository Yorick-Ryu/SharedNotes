package com.yorick.sharednotes.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun SharedNotesDropDownMenu(
    modifier: Modifier = Modifier,
    label: String = "Category",
    menuList: List<String>,
)



