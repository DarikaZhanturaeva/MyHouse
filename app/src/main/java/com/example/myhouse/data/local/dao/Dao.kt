package com.example.myhouse.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myhouse.data.network.model.camera.Camera
import com.example.myhouse.data.network.model.door.Data

@Dao
interface Dao {

    @Query("SELECT * FROM camera_data")
    suspend fun getAllCameras(): List<Camera>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(camera: Camera)

}