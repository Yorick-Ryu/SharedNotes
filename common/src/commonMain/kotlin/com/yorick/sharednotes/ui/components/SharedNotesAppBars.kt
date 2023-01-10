package com.yorick.sharednotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SharedNotesSearchBar(
    modifier: Modifier = Modifier,
    searchContent: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .background(MaterialTheme.colorScheme.surface, CircleShape),
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            tint = MaterialTheme.colorScheme.outline
        )
        Text(
            text = searchContent,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp, vertical = 18.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline
        )
        SharedNotesProfileImage(
            drawableResource = "avatar_11",
            description = "profile",
            modifier = Modifier
                .padding(12.dp)
                .size(32.dp)
        )
    }
}

@Composable
fun SharedNotesTopBar(
    title: String,
    isFullScreen: Boolean,
    modifier: Modifier = Modifier,
    onClickTitle: () -> Unit = {},
    onBackPressed: () -> Unit = {},
    actions: @Composable () -> Unit = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (isFullScreen) {
            IconButton(
                onClick = onBackPressed,
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Column(
            modifier = Modifier,
            horizontalAlignment = if (isFullScreen) Alignment.CenterHorizontally
            else Alignment.Start
        ) {
            TextButton(onClick = { onClickTitle() }) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Row {
            actions()
        }
    }
}

