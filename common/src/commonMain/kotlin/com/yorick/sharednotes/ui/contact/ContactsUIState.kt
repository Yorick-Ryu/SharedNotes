package com.yorick.sharednotes.ui.contact

import com.yorick.sharednotes.data.model.Account

data class ContactsUIState(
    val accounts: List<Account> = emptyList(),
    val selectedAccount: Account? = null,
    val isDetailOnlyOpen: Boolean = false,
    val loading: Boolean = false,
    val error: String? = null
)