package com.example.myhouse.di

import com.example.myhouse.data.repository.CameraRepository
import com.example.myhouse.data.repository.DoorRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val DoorRepositoryModule: Module = module {
    single { DoorRepository(get()) }
}
val CameraRepositoryModule: Module = module {
    single { CameraRepository(get()) }
}