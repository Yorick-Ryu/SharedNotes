package com.yorick.sharednotes.ui.note

import com.yorick.sharednotes.data.repository.NotesRepository
import com.yorick.sharednotes.data.repository.NotesRepositoryImpl
import com.yorick.sharednotes.ui.utils.SharedNotesContentType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class NotesViewModel(
    private val notesRepository: NotesRepository = NotesRepositoryImpl(),
) : ViewModel() {
    private val _uiState = MutableStateFlow(NotesUIState(loading = true))
    val uiState: StateFlow<NotesUIState> = _uiState

    init {
        observerNotes()
    }

    private fun observerNotes() {
        viewModelScope.launch {
            notesRepository.getAllNotes()
                .catch { ex ->
                    _uiState.value = NotesUIState(error = ex.message)
                }
                .collect { notes ->
                    _uiState.value = NotesUIState(
                        notes = notes,
                        selectedNote = notes.first()
                    )
                }
        }
    }

    fun setSelectedNote(noteId: Long, contentType: SharedNotesContentType) {
        val note = uiState.value.notes.find { it.id == noteId }
        _uiState.value = _uiState.value.copy(
            selectedNote = note,
            isDetailOnlyOpen = contentType == SharedNotesContentType.SINGLE_PANE
        )
    }

    fun closeDetailScreen() {
        _uiState.value = _uiState
            .value.copy(
                isDetailOnlyOpen = false,
                selectedNote = null
            )
    }
}