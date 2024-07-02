package com.example.myhouse.ui.fragments.camera

import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.myhouse.R
import com.example.myhouse.data.network.model.camera.Camera
import com.example.myhouse.databinding.FragmentCameraBinding
import com.example.myhouse.ui.base.BaseFragment
import com.example.myhouse.ui.fragments.door.SwipeDoor
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class CameraFragment : BaseFragment<FragmentCameraBinding>(FragmentCameraBinding::inflate) {

    private val viewModel: CameraViewModel by viewModel()
    private lateinit var cameraAdapter: CameraAdapter

    override fun setupViews() {
        setupRecycler()
        setupSwipeRefresh()
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getCamera().observe(viewLifecycleOwner, Observer {
                cameraAdapter.submitList(it)
            })
            viewModel.refreshCameraData()
        }
        binding.swipeRefreshLayout.setColorSchemeColors(
            ContextCompat.getColor(requireContext(), R.color.colorPrimary),
        )
    }

    private fun setupRecycler() {
        cameraAdapter = CameraAdapter()
        binding.rvCamera.adapter = cameraAdapter
        val itemTouchHelper = ItemTouchHelper(SwipeCamera(cameraAdapter))
        itemTouchHelper.attachToRecyclerView(binding.rvCamera)
    }

    override fun setupObservers() {
        viewModel.getCamera().observe(viewLifecycleOwner, Observer {
            cameraAdapter.submitList(it)
            binding.swipeRefreshLayout.isRefreshing = false
        })

    }

}