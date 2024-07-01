package com.example.myhouse.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.myhouse.data.api_service.ApiService
import com.example.myhouse.data.network.model.door.Data
import kotlinx.coroutines.Dispatchers

class DoorRepository(private val api : ApiService) {

    fun getDoors() : LiveData<List<Data>> {
        return liveData(Dispatchers.IO) {
            val response = api.getDoors()
            if (response.isSuccessful) {
                response.body()?.data?.let {
                    emit(it)
                }
            }
        }
    }

}