package com.example.myhouse.ui.fragments.door

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse.data.network.model.camera.Camera
import com.example.myhouse.data.network.model.door.Data
import com.example.myhouse.databinding.ItemDoorBinding
import com.example.myhouse.ui.fragments.camera.DoorItemCallback

class DoorAdapter : ListAdapter<Data, DoorAdapter.DoorViewHolder>(DoorItemCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DoorViewHolder {
        return DoorViewHolder(
            ItemDoorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DoorViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
    fun addToFavorites(position: Int) {
        val item = getItem(position)
        item.favorites = true
        notifyItemChanged(position)
    }

    class DoorViewHolder(private val binding: ItemDoorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(door: Data) {
            with(binding) {
                tvDoor.text = door.name
                itemView.setOnClickListener {
                    val position = bindingAdapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        imgFavorite.visibility = if (door.favorites) View.VISIBLE else View.GONE
                    }
                }
            }
        }
    }


    class DoorItemCallback : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Data, newItem: Data) = oldItem == newItem
    }
}