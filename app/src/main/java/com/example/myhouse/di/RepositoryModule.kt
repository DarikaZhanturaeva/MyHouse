package com.example.myhouse.di

import com.example.myhouse.data.repository.CameraRepository
import com.example.myhouse.data.repository.DoorRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    single { DoorRepository(get()) }
    single { CameraRepository(get()) }
}