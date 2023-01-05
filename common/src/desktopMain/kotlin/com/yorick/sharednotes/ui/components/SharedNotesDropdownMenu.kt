package com.yorick.sharednotes.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
actual fun SharedNotesDropDownMenu(
    modifier: Modifier,
    label: String ,
    menuList: List<String>,
){
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
            value = category,
            onValueChange = {
                category = it
            },
            enabled = true,
            trailingIcon = {
                IconButton(onClick = {
                    expanded = true
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

    }
}