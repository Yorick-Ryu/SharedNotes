package com.yorick.sharednotes.ui.edit


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yorick.sharednotes.data.model.Account
import com.yorick.sharednotes.data.model.Category
import com.yorick.sharednotes.data.model.Note
import com.yorick.sharednotes.data.model.Tag
import com.yorick.sharednotes.data.repository.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class EditViewModel(
    private val notesRepository: NotesRepository = NotesRepositoryImpl(),
    private val categoriesRepository: CategoriesRepository = CategoriesRepositoryImpl(),
    private val tagsRepository: TagsRepository = TagsRepositoryImpl(),
    private val accountsRepository: AccountsRepository = AccountsRepositoryImpl(),
) : ViewModel() {
    private val _uiState = MutableStateFlow(EditUIState(loading = true))
    val uiState: StateFlow<EditUIState> = _uiState

    var noteSubject by mutableStateOf("")
    var noteBody by mutableStateOf("")
    var isNoteInfoDialogOpen by mutableStateOf(false)
    var isEditModeEnabled by mutableStateOf(false)
    var isSaveDialogOpen by mutableStateOf(false)
    val titleEditorFocus = FocusRequester()
    var editingNote: Note? by mutableStateOf(null)

    var noteId: Long by mutableStateOf(-1L)

    var mode by mutableStateOf(
        if ((uiState.value.notes.find { it.id == noteId }) == null) EditScreenMode.ADD_NOTE_MODE else EditScreenMode.EDIT_NOTE_MODE
    )

    init {
        observerNotes()
        observerCategories()
        observerTags()
        observerAccount()
    }

    private fun addNewNoteInit() {
        editingNote = Note(
            id = -2L,
            author = uiState.value.account!!,
            subject = "",
            body = "",
            category = uiState.value.categories.first(),
            tag = uiState.value.tags,
            createdAt = "2 mim ago"
        )
        noteSubject = ""
        noteBody = ""
        editingNote = null
        isSaveDialogOpen = false
        isNoteInfoDialogOpen = true
        isEditModeEnabled = true
    }

    private fun observerNotes() {
        viewModelScope.launch {
            notesRepository.getAllNotes()
                .catch { ex ->
                    _uiState.value = EditUIState(error = ex.message)
                }
                .collect { notes ->
                    _uiState.value = _uiState.value.copy(
                        notes = notes
                    )
                }
        }
    }

    private fun observerCategories() {
        viewModelScope.launch {
            categoriesRepository.getAllCategories()
                .catch { ex ->
                    _uiState.value = EditUIState(error = ex.message)
                }
                .collect { categories ->
                    _uiState.value = _uiState.value.copy(
                        categories = categories
                    )
                }
        }
    }

    private fun observerTags() {
        viewModelScope.launch {
            tagsRepository.getAllTags()
                .catch { ex ->
                    _uiState.value = EditUIState(error = ex.message)
                }
                .collect { tags ->
                    _uiState.value = _uiState.value.copy(
                        tags = tags
                    )
                }
        }
    }

    private fun observerAccount() {
        viewModelScope.launch {
            accountsRepository.getUserAccount()
                .catch { ex ->
                    _uiState.value = EditUIState(error = ex.message)
                }
                .collect { account ->
                    _uiState.value = _uiState.value.copy(
                        account = account
                    )
                }
        }
    }

     fun onInit() {

        if (editingNote == null) {
            addNewNoteInit()
        } else {
            onEditNote(editingNote!!)
        }
    }

    private fun onEditNote(newEditingNote: Note) {
        isNoteInfoDialogOpen = false
        isEditModeEnabled = true
        editingNote = newEditingNote
        noteSubject = newEditingNote.subject
        noteBody = newEditingNote.body
    }

    fun onConfirm() {
        Log.d("yu", "onConfirm: ")
        if (noteSubject != "") {
            isNoteInfoDialogOpen = false
        } else {
            titleEditorFocus.requestFocus()
        }
    }

    fun modeChange() {
        isEditModeEnabled = !isEditModeEnabled
    }

    fun onBodyValueChange(newNoteBody: String) {
        noteBody = newNoteBody
    }

    fun onSubjectValueChange(newNoteSubject: String) {
        noteSubject = newNoteSubject
    }

    fun onBackPress() {
        Log.d("TAG", "onBackPress: ")
        isSaveDialogOpen = true
    }

    fun save() {
        if (noteBody == "") {
        } else {

        }
    }
}
