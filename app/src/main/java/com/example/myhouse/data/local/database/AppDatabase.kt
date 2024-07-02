package com.example.myhouse.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myhouse.data.local.dao.Dao
import com.example.myhouse.data.network.model.camera.Camera

@Database(entities = [Camera::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cameraDao(): Dao
}