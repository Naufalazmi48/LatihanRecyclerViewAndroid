package com.example.submissionandroidpemula.application.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.submissionandroidpemula.R
import com.example.submissionandroidpemula.databinding.FragmentAboutBinding
import com.example.submissionandroidpemula.utils.MyPath

class AboutFragment : Fragment(), View.OnClickListener {
    
    companion object {
        private var INSTANCE: AboutFragment? = null
        fun getInstance(): AboutFragment =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: AboutFragment()
            }
    }
    
    private var _binding:FragmentAboutBinding? = null
    private val binding get() = _binding!!
    private val avatarFile = "avatar.jpeg"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        loadAvatar()
        setupListener()
        return binding.root
    }

    private fun loadAvatar() {
        Glide.with(this)
            .load(Uri.parse(MyPath.DEVELOPER_ASSETS + avatarFile))
            .into(binding.avatar)
    }

    private fun setupListener() {
        binding.linkedin.setOnClickListener(this)
        binding.instagram.setOnClickListener(this)
        binding.github.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.linkedin -> moveToMediaSocial(MyPath.MediaSocials.LINKEDIN)
            R.id.github -> moveToMediaSocial(MyPath.MediaSocials.GITHUB)
            R.id.instagram -> moveToMediaSocial(MyPath.MediaSocials.INSTAGRAM)
        }
    }

    private fun moveToMediaSocial(path: MyPath.MediaSocials) {
        val intent = Intent(Intent.ACTION_VIEW)
            .setData(Uri.parse(path.link))
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}