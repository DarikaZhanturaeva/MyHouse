package com.example.myhouse.ui.fragments.camera

import com.example.myhouse.databinding.FragmentCameraBinding
import com.example.myhouse.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class CameraFragment : BaseFragment<FragmentCameraBinding>(FragmentCameraBinding::inflate) {

    private val viewModel : CameraViewModel by viewModel()
    private lateinit var cameraAdapter: CameraAdapter

    override fun setupViews() {
        setupRecycler()
    }

    private fun setupRecycler() {
        cameraAdapter = CameraAdapter()
        binding.rvCamera.adapter = cameraAdapter
    }
    override fun setupObservers() {
        viewModel.getCamera().observe(viewLifecycleOwner) {
            cameraAdapter.submitList(it)
        }
    }

}