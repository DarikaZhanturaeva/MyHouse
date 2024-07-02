package com.example.myhouse.ui.fragments.door

import androidx.recyclerview.widget.ItemTouchHelper
import com.example.myhouse.databinding.FragmentDoorBinding
import com.example.myhouse.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DoorFragment : BaseFragment<FragmentDoorBinding>(FragmentDoorBinding::inflate) {

    private val viewModel: DoorViewModel by viewModel()
    private lateinit var doorAdapter: DoorAdapter

    override fun setupViews() {
        setupRecycler()
    }

    private fun setupRecycler() {
        doorAdapter = DoorAdapter()
        binding.rvDoor.adapter = doorAdapter
        val itemTouchHelper = ItemTouchHelper(SwipeDoor(doorAdapter))
        itemTouchHelper.attachToRecyclerView(binding.rvDoor)
    }

    override fun setupObservers() {
        viewModel.getDoors().observe(viewLifecycleOwner) {
            doorAdapter.submitList(it)
        }
    }
}