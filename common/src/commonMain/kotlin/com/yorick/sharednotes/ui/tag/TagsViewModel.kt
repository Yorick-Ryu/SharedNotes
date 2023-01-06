package com.yorick.sharednotes.ui.tag

import com.yorick.sharednotes.data.repository.NotesRepository
import com.yorick.sharednotes.data.repository.NotesRepositoryImpl
import com.yorick.sharednotes.data.repository.TagsRepository
import com.yorick.sharednotes.data.repository.TagsRepositoryImpl
import com.yorick.sharednotes.ui.utils.SharedNotesContentType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class TagsViewModel(
    private val tagsRepository: TagsRepository = TagsRepositoryImpl(),
    private val notesRepository: NotesRepository = NotesRepositoryImpl(),
) : ViewModel() {
    private val _uiState = MutableStateFlow(TagsUIState(loading = true))
    val uiState: StateFlow<TagsUIState> = _uiState

    init {
        observerTags()
        observerNotes()

    }

    private fun observerTags() {
        viewModelScope.launch {
            tagsRepository.getAllTags()
                .catch { ex ->
                    _uiState.value = TagsUIState(error = ex.message)
                }
                .collect { tags ->
                    _uiState.value = TagsUIState(
                        tags = tags
                    )
                }
        }
    }

    private fun observerNotes() {
        viewModelScope.launch {
            notesRepository.getAllNotes()
                .catch { ex ->
                    _uiState.value = TagsUIState(error = ex.message)
                }
                .collect { notes ->
                    _uiState.value = _uiState.value.copy(
                        notes = notes
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