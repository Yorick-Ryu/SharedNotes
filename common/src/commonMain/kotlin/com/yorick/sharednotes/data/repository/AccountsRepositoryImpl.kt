package com.yorick.sharednotes.data.repository

import com.yorick.sharednotes.data.local.LocalAccountsDataProvider
import com.yorick.sharednotes.data.model.Account
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AccountsRepositoryImpl : AccountsRepository {
    override fun getUserAccount(): Flow<Account> = flow {
        emit(LocalAccountsDataProvider.UserAccount)
    }

    override fun getAllContact(): Flow<List<Account>> = flow {
        emit(LocalAccountsDataProvider.allUserContactAccounts)
    }

    override fun getContactAccountById(uid: Long): Flow<Account> = flow {
        emit(LocalAccountsDataProvider.getContactAccountById(uid))
    }
}