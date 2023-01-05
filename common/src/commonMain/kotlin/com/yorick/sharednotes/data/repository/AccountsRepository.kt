package com.yorick.sharednotes.data.repository

import com.yorick.sharednotes.data.model.Account
import kotlinx.coroutines.flow.Flow

interface AccountsRepository {
    fun getUserAccount(): Flow<Account>
    fun getAllContact(): Flow<List<Account>>
    fun getContactAccountById(uid: Long): Flow<Account>
}