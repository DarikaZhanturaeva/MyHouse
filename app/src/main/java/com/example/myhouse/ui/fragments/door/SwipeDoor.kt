package com.example.myhouse.ui.fragments.door

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SwipeDoor (private val adapter: DoorAdapter) : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
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