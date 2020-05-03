package com.akshat.synerzip.model


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("label")
    val label: String
)