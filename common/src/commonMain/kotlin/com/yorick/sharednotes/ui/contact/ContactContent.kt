package com.yorick.sharednotes.ui.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yorick.sharednotes.data.model.Account
import com.yorick.sharednotes.ui.components.SharedNotesProfileImage

@Composable
fun ContactContent(
    modifier: Modifier = Modifier,
    account: Account
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.large
            ),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            SharedNotesProfileImage(
                modifier = modifier.size(120.dp),
                drawableResource = account.avatar,
                description = account.fullName
            )
        }
        val items = mapOf(
            "FirstName" to account.firstName,
            "LastName" to account.lastName,
            "PhoneNumber" to account.phoneNumber,
            "Email" to account.email,
            "AltEmail" to account.altEmail,
        )
        for (item in items) {
            AccountInfoItem(itemName = item.key, itemInfo = item.value)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                onClick = { /*TODO*/ },
            ) {
                Icon(imageVector = Icons.Default.Star, contentDescription = "star")
                Text(
                    modifier = modifier.padding(start = 4.dp),
                    text = "Star",
                )
            }
            Button(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                onClick = { /*TODO*/ },
            ) {
                Icon(imageVector = Icons.Default.Article, contentDescription = "notes")
                Text(
                    modifier = modifier.padding(start = 4.dp),
                    text = "Notes",
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountInfoItem(
    modifier: Modifier = Modifier,
    itemName: String,
    itemInfo: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 15.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = itemName,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.outline
            )
            Text(
                text = itemInfo,
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}