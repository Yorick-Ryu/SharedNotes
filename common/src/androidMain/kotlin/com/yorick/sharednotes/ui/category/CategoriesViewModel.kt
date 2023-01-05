package com.yorick.sharednotes.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yorick.sharednotes.data.repository.CategoriesRepository
import com.yorick.sharednotes.data.repository.CategoriesRepositoryImpl
import com.yorick.sharednotes.data.repository.NotesRepository
import com.yorick.sharednotes.data.repository.NotesRepositoryImpl
import com.yorick.sharednotes.ui.utils.SharedNotesContentType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val categoriesRepository: CategoriesRepository = CategoriesRepositoryImpl(),
    private val notesRepository: NotesRepository = NotesRepositoryImpl(),
) : ViewModel() {
    private val _uiState = MutableStateFlow(CategoriesUIState(loading = true))
    val uiState: StateFlow<CategoriesUIState> = _uiState

    init {
        observerCategories()
        getCategoryNotes()
    }

    private fun observerCategories() {
        viewModelScope.launch {
            categoriesRepository.getAllCategories()
                .catch { ex ->
                    _uiState.value = CategoriesUIState(error = ex.message)
                }
                .collect { categories ->
                    _uiState.value = CategoriesUIState(
                        categories = categories,
                        selectedCategory = categories.first()
                    )
                }
        }
    }

    private fun getCategoryNotes() {
        viewModelScope.launch {
            uiState.value.selectedCategory?.let {
                notesRepository.getCategoryNotes(it)
                    .catch { ex ->
                        _uiState.value = CategoriesUIState(error = ex.message)
                    }
                    .collect { categoryNotes ->
                        _uiState.value = _uiState.value.copy(
                            categoryNotes = categoryNotes,
                        )
                    }
            }
        }
    }

    fun setSelectedCategory(categoryId: Long, contentType: SharedNotesContentType) {
        val category = uiState.value.categories.find { it.id == categoryId }
        _uiState.value = _uiState.value.copy(
            selectedCategory = category,
            isDetailOnlyOpen = contentType == SharedNotesContentType.SINGLE_PANE
        )
        getCategoryNotes()
    }

    fun closeDetailScreen() {
        _uiState.value = _uiState.value.copy(
            isDetailOnlyOpen = false,
            selectedCategory = null
        )
    }
}