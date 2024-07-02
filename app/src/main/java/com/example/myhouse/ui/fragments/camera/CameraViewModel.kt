package com.example.myhouse.ui.fragments.camera

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myhouse.data.repository.CameraRepository
import kotlinx.coroutines.Dispatchers

class CameraViewModel(
    private val repository: CameraRepository
) : ViewModel(){

    fun getCamera() = repository.getCamera()

    fun refreshCameraData() = liveData(Dispatchers.IO) {
        emitSource(repository.getCamera())
    }
}