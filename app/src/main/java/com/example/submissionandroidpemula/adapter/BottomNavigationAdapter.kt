package com.example.submissionandroidpemula.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.submissionandroidpemula.application.fragments.AboutFragment
import com.example.submissionandroidpemula.application.fragments.CartFragment
import com.example.submissionandroidpemula.application.fragments.HomeFragment
import com.example.submissionandroidpemula.application.MENU

class BottomNavigationAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = MENU.values().size

    override fun createFragment(position: Int): Fragment {
        return when(MENU.values()[position]) {
            MENU.HOME -> HomeFragment()
            MENU.CART -> CartFragment()
            MENU.ABOUT -> AboutFragment.getInstance()
        }
    }

}