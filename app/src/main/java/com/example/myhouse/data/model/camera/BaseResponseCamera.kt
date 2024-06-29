package com.example.myhouse.data.model.camera

import com.google.gson.annotations.SerializedName

data class BaseResponseCamera(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val `data`: Data
)