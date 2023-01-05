package com.yorick.sharednotes.data.repository

import com.yorick.sharednotes.data.local.LocalCategoriesDataProvider
import com.yorick.sharednotes.data.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CategoriesRepositoryImpl: CategoriesRepository {
    override fun getAllCategories(): Flow<List<Category>> = flow {
        emit(LocalCategoriesDataProvider.allCategory)
    }

    override fun getCategoryById(id:Long): Flow<Category> = flow {
        emit(LocalCategoriesDataProvider.getCategoryById(id))
    }
}