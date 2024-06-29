package com.example.myhouse.di

import com.example.myhouse.ui.fragments.camera.CameraViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule : Module = module {
    viewModel {
        CameraViewModel(get())
    }
}