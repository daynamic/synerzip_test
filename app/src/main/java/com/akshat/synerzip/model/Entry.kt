package com.akshat.synerzip.model


import com.google.gson.annotations.SerializedName

data class Entry(
    @SerializedName("id")
    val id: Id,
    @SerializedName("im:image")
    val imImage: List<ImImage>,
    @SerializedName("im:name")
    val imName: ImName
)