package com.akshat.synerzip.network

import com.akshat.synerzip.BuildConfig
import com.xpediator.esuite.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET


/**
 * Created by Akshat on 2020-05-02.
 */

interface FeedApi {

    @GET(Constants.feedUrl)
    suspend fun getList(): Response<com.akshat.synerzip.model.Response>

    companion object {

        operator fun invoke(): FeedApi {
            //For logging network requests.
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
            val okHttpClient = OkHttpClient().newBuilder()

                .addInterceptor(loggingInterceptor)
                .build()
            return Retrofit.Builder()
                .baseUrl(Constants.base_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(FeedApi::class.java)
        }

    }
}