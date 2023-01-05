package com.yorick.sharednotes.data.repository

import com.yorick.sharednotes.data.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {
    fun getAllCategories(): Flow<List<Category>>
    fun getCategoryById(id:Long): Flow<Category>
}