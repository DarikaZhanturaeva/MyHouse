package com.example.myhouse.ui.fragments.camera

import androidx.lifecycle.ViewModel
import com.example.myhouse.data.repository.CameraRepository

class CameraViewModel(
    private val repository: CameraRepository
) : ViewModel(){

    fun getCamera() = repository.getCamera()

}