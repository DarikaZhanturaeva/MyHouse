package com.example.myhouse.data.network.model.door

import com.google.gson.annotations.SerializedName

data class BaseResponseDoor(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val `data`: List<Data>
)