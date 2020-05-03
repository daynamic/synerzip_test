package com.akshat.synerzip.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akshat.synerzip.repo.FeedRepo

/**
 * Created by Akshat on 2020-05-03.
 */
@Suppress("UNCHECKED_CAST")
class GridViewModelFactory(private val repository: FeedRepo): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GridViewModel(repository) as T
    }
}