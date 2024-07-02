package com.example.myhouse.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.myhouse.data.api_service.ApiService
import com.example.myhouse.data.local.dao.Dao
import com.example.myhouse.data.network.model.camera.Camera
import kotlinx.coroutines.Dispatchers

class CameraRepository(
    private val api : ApiService,
    private val cameraDao: Dao
    ) {

    fun getCamera() : LiveData<List<Camera>>{
        return liveData(Dispatchers.IO) {
            val response = api.getCameras()
            if (response.isSuccessful) {
                response.body()?.data?.cameras?.let {
                    emit(it)
                }
            }
        }
    }
    suspend fun getAllCameras(): List<Camera> {
        return cameraDao.getAllCameras()
    }

    suspend fun insert(camera: Camera) {
        cameraDao.insert(camera)
    }
}