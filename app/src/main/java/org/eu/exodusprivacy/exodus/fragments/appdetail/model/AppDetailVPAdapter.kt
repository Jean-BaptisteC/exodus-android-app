package org.eu.exodusprivacy.exodus.fragments.appdetail.model

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.eu.exodusprivacy.exodus.fragments.appdetail.subfrags.ADPermissionsFragment
import org.eu.exodusprivacy.exodus.fragments.appdetail.subfrags.ADTrackersFragment

class AppDetailVPAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> ADPermissionsFragment()
            else -> ADTrackersFragment()
        }
    }
}
