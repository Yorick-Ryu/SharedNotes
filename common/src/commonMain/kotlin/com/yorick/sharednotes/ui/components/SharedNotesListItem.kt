package com.yorick.sharednotes.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.yorick.sharednotes.data.model.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharedNotesListItem(
    modifier: Modifier = Modifier,
    category: Category,
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
            .clickable { navigateToDetail(category.id) },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        )

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = category.name,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = category.sum.toString(),
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}