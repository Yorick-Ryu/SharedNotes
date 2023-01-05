package com.yorick.sharednotes.data.repository

import com.yorick.sharednotes.data.local.LocalTagsDataProvider
import com.yorick.sharednotes.data.model.Tag
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TagsRepositoryImpl: TagsRepository {
    override fun getAllTags(): Flow<List<Tag>> = flow {
        emit(LocalTagsDataProvider.allTags)
    }

    override fun getTagById(id:Long): Flow<Tag> = flow {
        emit(LocalTagsDataProvider.getTagById(id))
    }
}