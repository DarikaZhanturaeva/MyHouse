package com.example.myhouse.data.model.camera

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("room")
    val room: List<String>,
    @SerializedName("cameras")
    val cameras: List<Camera>
)