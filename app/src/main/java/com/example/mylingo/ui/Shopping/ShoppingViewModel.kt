package com.example.mylingo.ui.Shopping

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.mylingo.Repository.itemsRepository
import com.example.mylingo.databinding.FragmentShoppingBinding
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class ShoppingViewModel @Inject constructor(
    private val repository: itemsRepository
):ViewModel(){

    private var _binding: FragmentShoppingBinding? = null
    private val binding get() = _binding!!

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val Items = currentQuery.switchMap {queryString->
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    fun searchitems(query:String){
        currentQuery.value=query
    }

    companion object {
        private const val DEFAULT_QUERY="watch"
    }

}