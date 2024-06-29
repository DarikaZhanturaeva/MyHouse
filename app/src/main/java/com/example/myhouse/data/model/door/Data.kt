package com.example.myhouse.data.model.door

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("name")
    val name: String,
    @SerializedName("room")
    val room: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("favorites")
    val favorites: Boolean,
    @SerializedName("snapshot")
    val snapshot: String
)