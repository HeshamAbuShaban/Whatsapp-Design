package dev.training.whatsapp_design.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import javax.inject.Inject


class ViewPagerAdapter @Inject constructor(
    private val fragmentList: ArrayList<Fragment>,
    fragmentActivity: FragmentActivity,
) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment = fragmentList[position]
    override fun getItemCount(): Int = fragmentList.size
}