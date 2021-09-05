package com.example.submissionandroidpemula.application.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submissionandroidpemula.R
import com.example.submissionandroidpemula.application.MainActivity
import com.example.submissionandroidpemula.core.source.local.ISharedPreference
import com.example.submissionandroidpemula.core.source.local.SharedPreference
import kotlinx.coroutines.*

class SplashScreenActivity : AppCompatActivity() {
    private val activityScope = CoroutineScope(Dispatchers.Main)
    private val sharedPreferences: ISharedPreference = SharedPreference(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        if (!isVisibleSplashScreen()) moveToMainActivity()

        activityScope.launch {
            delay(3000)
            setVisibilitySplashScreen()
            moveToMainActivity()
        }
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
        finish()
    }
    private fun isVisibleSplashScreen() = sharedPreferences.getStatusVisibilitySplashScreen()
    private fun setVisibilitySplashScreen() =
        sharedPreferences.setStatusVisibilitySplashScreen(
            visibility = false
        )

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }
}