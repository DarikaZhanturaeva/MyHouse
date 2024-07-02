package com.example.myhouse.data.network.model.camera

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "camera_data")
data class Camera(
    @PrimaryKey
    @SerializedName("name")
    val name: String,
    @SerializedName("snapshot")
    val snapshot: String,
    @SerializedName("room")
    val room: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("favorites")
    var favorites: Boolean,
    @SerializedName("rec")
    val rec: Boolean
)