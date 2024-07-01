package com.example.myhouse.ui.fragments.camera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myhouse.data.network.model.camera.Camera
import com.example.myhouse.databinding.ItemCameraBinding

class CameraAdapter : ListAdapter<Camera, CameraAdapter.CameraViewHolder>(DoorItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        val binding =
            ItemCameraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CameraViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class CameraViewHolder(private val binding: ItemCameraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(camera: Camera) {
            with(binding) {
                binding.tvCamera.text = camera.name
                binding.imgCamera.load(camera.snapshot)
            }
        }
    }
}


class DoorItemCallback : DiffUtil.ItemCallback<Camera>() {
    override fun areItemsTheSame(oldItem: Camera, newItem: Camera) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Camera, newItem: Camera) = oldItem == newItem
}