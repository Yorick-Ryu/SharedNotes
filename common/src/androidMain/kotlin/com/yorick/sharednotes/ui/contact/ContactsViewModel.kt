package com.yorick.sharednotes.ui.contact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yorick.sharednotes.data.model.Account
import com.yorick.sharednotes.data.repository.AccountsRepository
import com.yorick.sharednotes.data.repository.AccountsRepositoryImpl
import com.yorick.sharednotes.ui.utils.SharedNotesContentType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ContactsViewModel(
    private val accountsRepository: AccountsRepository = AccountsRepositoryImpl()
) : ViewModel() {
    private val _uiState = MutableStateFlow(ContactsUIState(loading = true))
    val uiState: StateFlow<ContactsUIState> = _uiState

    init {
        observerContacts()
    }

    private fun observerContacts() {
        viewModelScope.launch {
            accountsRepository.getAllContact()
                .catch { ex ->
                    _uiState.value = ContactsUIState(error = ex.message)
                }
                .collect { accounts ->
                    _uiState.value = ContactsUIState(
                        accounts = accounts,
                        selectedAccount = accounts.first()
                    )
                }
        }
    }

    fun setSelectedAccount(accountId: Long, contentType: SharedNotesContentType) {
        val account = uiState.value.accounts.find { it.id == accountId }
        _uiState.value = _uiState.value.copy(
            selectedAccount = account,
            isDetailOnlyOpen = contentType == SharedNotesContentType.SINGLE_PANE
        )
    }

    fun closeDetailScreen() {
        _uiState.value = _uiState.value.copy(
            isDetailOnlyOpen = false,
            selectedAccount = null
        )
    }
}