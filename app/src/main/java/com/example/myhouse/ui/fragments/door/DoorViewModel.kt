package com.example.myhouse.ui.fragments.door

import androidx.lifecycle.ViewModel
import com.example.myhouse.data.repository.DoorRepository

class DoorViewModel(
    private val repository: DoorRepository
) : ViewModel() {

    fun getDoors() = repository.getDoors()

}