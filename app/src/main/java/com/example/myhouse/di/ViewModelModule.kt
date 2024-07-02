package com.example.myhouse.di

import androidx.room.Room
import com.example.myhouse.data.local.database.AppDatabase
import com.example.myhouse.ui.fragments.camera.CameraViewModel
import com.example.myhouse.ui.fragments.door.DoorViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule : Module = module {
    viewModel {
        CameraViewModel(get())
    }
    viewModel {
        DoorViewModel(get())
    }
}