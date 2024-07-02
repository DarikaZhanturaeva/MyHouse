package com.example.myhouse.ui.fragments.camera

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse.ui.fragments.door.DoorAdapter

class SwipeCamera (private val adapter: CameraAdapter) : ItemTouchHelper.SimpleCallback(0,
    ItemTouchHelper.RIGHT){
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.getBindingAdapterPosition()
        adapter.addToFavorites(position)
    }
}