package com.example.ts.view.adapters.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

open class FragmentPagerAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    val fragmentList: List<Fragment>
): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = fragmentList.size
    override fun createFragment(position: Int) = fragmentList[position]

    fun getFragmentByPosition(position: Int) = fragmentList[position]
    fun getTitleByPosition(position: Int) = ""
}