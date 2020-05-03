package com.akshat.synerzip.repo

import com.akshat.synerzip.model.Response
import com.akshat.synerzip.network.FeedApi
import com.akshat.synerzip.utils.SafeApiRequest
import okhttp3.RequestBody

/**
 * Created by Akshat on 2020-05-02.
 */

class FeedRepo :SafeApiRequest(){

    suspend fun getList(): Response {
        return apiRequest { FeedApi().getList() }
    }


}