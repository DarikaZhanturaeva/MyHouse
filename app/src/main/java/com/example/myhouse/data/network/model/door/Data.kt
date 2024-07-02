package com.example.myhouse.data.network.model.door

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "door_data")
data class Data(
    @PrimaryKey
    @SerializedName("name")
    val name: String,
    @SerializedName("room")
    val room: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("favorites")
    var favorites: Boolean,
    @SerializedName("snapshot")
    val snapshot: String
)