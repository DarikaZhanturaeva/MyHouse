package com.example.myhouse.ui.fragments.camera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myhouse.data.model.camera.Camera
import com.example.myhouse.databinding.ItemCameraBinding

class CameraAdapter : ListAdapter<Camera, CameraAdapter.CameraViewHolder>(CameraItemCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CameraViewHolder {
        return CameraViewHolder(
            ItemCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class CameraViewHolder(private val binding: ItemCameraBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(camera: Camera) {
            with(binding) {
                tvCamera.text = camera.name
                imgCamera.load(camera.snapshot)
            }
        }
    }
}

class CameraItemCallback : DiffUtil.ItemCallback<Camera>() {
    override fun areItemsTheSame(oldItem: Camera, newItem: Camera) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Camera, newItem: Camera) = oldItem == newItem
}