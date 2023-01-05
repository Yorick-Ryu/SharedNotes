package com.yorick.sharednotes.ui.contact

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.yorick.sharednotes.data.model.Account
import com.yorick.sharednotes.ui.components.SharedNotesProfileImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsListItem(
    modifier: Modifier = Modifier,
    account: Account,
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
            .clickable { navigateToDetail(account.id) },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            SharedNotesProfileImage(
                modifier = Modifier.size(60.dp),
                drawableResource = account.avatar,
                description = account.fullName
            )
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = account.fullName,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    modifier = Modifier.padding(top = 6.dp),
                    text = account.email,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )
            }

        }
    }
}
