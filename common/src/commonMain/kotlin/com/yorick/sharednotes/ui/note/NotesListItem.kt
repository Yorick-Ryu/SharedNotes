package com.yorick.sharednotes.ui.note

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.yorick.sharednotes.data.model.Note
import com.yorick.sharednotes.ui.components.SharedNotesProfileImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesListItem(
    modifier: Modifier = Modifier,
    note: Note,
    isSelectable: Boolean = false,
    isSelected: Boolean = false,
    navigateToDetail: (Long) -> Unit = {}
) {
    val semanticsModifier =
        if (isSelectable) modifier.semantics { selected = isSelected }
        else modifier
    Card(
        modifier = semanticsModifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { navigateToDetail(note.id) },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = note.subject,
                    style = MaterialTheme.typography.titleLarge
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    Icon(
                        imageVector = Icons.Default.StarBorder,
                        contentDescription = "Favorite",
                        tint = MaterialTheme.colorScheme.outline
                    )
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                SharedNotesProfileImage(
                    drawableResource = note.author.avatar,
                    description = note.author.fullName
                )
                Column(
                    modifier = Modifier.padding(start = 12.dp)
                ) {
                    Text(
                        text = note.author.firstName,
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = note.createdAt,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
                MyChip(
                    modifier = Modifier.padding(start = 20.dp),
                    label = note.category.name
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyChip(
    modifier: Modifier = Modifier,
    label: String
) {
    AssistChip(
        modifier = modifier,
        onClick = { /*TODO*/ },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Category,
                contentDescription = "Category"
            )
        }
    )
}