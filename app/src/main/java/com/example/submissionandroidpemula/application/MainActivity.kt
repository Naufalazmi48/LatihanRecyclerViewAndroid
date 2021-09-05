package com.example.submissionandroidpemula.application

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.submissionandroidpemula.R
import com.example.submissionandroidpemula.adapter.BottomNavigationAdapter
import com.example.submissionandroidpemula.application.viewmodels.MainViewModel
import com.example.submissionandroidpemula.databinding.ActivityMainBinding
import com.example.submissionandroidpemula.utils.MyViewModelFactory
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var navigationAdapter = BottomNavigationAdapter(this)
    private val onPageChangeCallback = object: ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            when(position) {
                0 -> binding.bottomNavBar.selectedItemId = R.id.home
                1 -> binding.bottomNavBar.selectedItemId = R.id.cart
                2 -> binding.bottomNavBar.selectedItemId = R.id.about
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = MyViewModelFactory(this).create(MainViewModel::class.java)
        binding.viewPager.adapter = navigationAdapter
        binding.viewPager.registerOnPageChangeCallback(onPageChangeCallback)
        binding.bottomNavBar.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> binding.viewPager.setCurrentItem(0, true)
            R.id.cart -> binding.viewPager.setCurrentItem(1, true)
            R.id.about -> binding.viewPager.setCurrentItem(2, true)
        }
        return true
    }
}