package com.akshat.synerzip.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("feed")
    val feed: Feed
)