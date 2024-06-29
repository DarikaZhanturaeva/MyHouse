package com.example.myhouse.data.api_service

import com.example.myhouse.data.model.camera.BaseResponseCamera
import com.example.myhouse.data.model.door.BaseResponseDoor
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("cameras")
    suspend fun getCameras(): Response<BaseResponseCamera>

    @GET("doors")
    suspend fun getDoors(): Response<BaseResponseDoor>

}