package com.example.mylingo.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mylingo.api.itemsApi
import retrofit2.HttpException
import java.io.IOException

private const val ITEMS_STARTING_PAGE_INDEX=1

class itemsPagingSource(
    private val ItemsApi:itemsApi,
    private val query:String
) :PagingSource<Int,items>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, items>
    {
        val position = params.key ?: ITEMS_STARTING_PAGE_INDEX
        return try{
            val response = ItemsApi.searchitems(query,position,params.loadSize)
            val Items = response.results
            LoadResult.Page(
                data=Items,
                prevKey= if (position == ITEMS_STARTING_PAGE_INDEX) null else position-1,
                nextKey = if (Items.isEmpty()) null else  position+1
            )
        } catch (exception: IOException){
            LoadResult.Error(exception)
        } catch (exception: HttpException){
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, items>): Int?
    {
        return state.anchorPosition?.let{ anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}