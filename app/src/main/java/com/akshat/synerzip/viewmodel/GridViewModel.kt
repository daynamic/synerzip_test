package com.akshat.synerzip.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akshat.synerzip.model.Entry
import com.akshat.synerzip.presenter.Callbacks
import com.akshat.synerzip.repo.FeedRepo
import com.akshat.synerzip.utils.ApiExceptions
import com.xpediator.esuite.utils.Coroutines
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import org.json.JSONObject

/**
 * Created by Akshat on 2020-05-01.
 */

class GridViewModel (private val repository: FeedRepo): ViewModel(){
    var authListener: Callbacks? = null
    private val _providedList = MutableLiveData<List<Entry>>()
    val providedList: LiveData<List<Entry>>
        get() = _providedList

    fun getList() {
        authListener?.onstarted()

        Coroutines.main {
            try {
                val authResponse = repository.getList()
                if (authResponse.feed==null) {
                    authListener?.onFailure("Not Success")
                }
                else{
                    _providedList.value = authResponse.feed.entry
                    authListener?.onSuccess()
                    return@main
                }
            } catch (e: ApiExceptions) {
                authListener?.onFailure(e.message!!)
            }
        }
    }



}