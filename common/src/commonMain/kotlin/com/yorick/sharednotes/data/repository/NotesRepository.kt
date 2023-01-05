package com.yorick.sharednotes.data.repository

import com.yorick.sharednotes.data.model.Category
import com.yorick.sharednotes.data.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    fun getAllNotes(): Flow<List<Note>>
    fun getCategoryNotes(category: Category): Flow<List<Note>>
    fun getNoteFromId(id: Long): Flow<Note?>
}