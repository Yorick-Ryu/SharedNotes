package com.yorick.sharednotes.data.repository

import com.yorick.sharednotes.data.model.Tag
import kotlinx.coroutines.flow.Flow

interface TagsRepository {
    fun getAllTags(): Flow<List<Tag>>
    fun getTagById(id:Long):Flow<Tag>
}