package com.example.myhouse.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myhouse.ui.fragments.camera.CameraFragment
import com.example.myhouse.ui.fragments.door.DoorFragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CameraFragment()
            1 -> DoorFragment()
            else -> throw IllegalStateException("Unexpected position: $position")
        }
    }
}
