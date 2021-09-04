package com.example.mylingo.Repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.mylingo.api.itemsApi
import com.example.mylingo.data.itemsPagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class itemsRepository @Inject constructor(private val ItemsApi:itemsApi) {

    fun getSearchResults(query:String) =
        Pager(
            config = PagingConfig(
                pageSize=20,
                maxSize=100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {itemsPagingSource(ItemsApi,query)}
        ).liveData
}