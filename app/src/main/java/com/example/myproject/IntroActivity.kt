package com.example.myproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.myproject.LoginActivity
import com.example.myproject.R

class IntroActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        // Find views
        videoView = findViewById(R.id.videoView)
        val btnGetStarted = findViewById<Button>(R.id.btnGetStarted)

        // Set up video
        val videoUri = Uri.parse("android.resource://${packageName}/${R.raw.crucial_intro}")
        videoView.setVideoURI(videoUri)

        // Start video & loop it
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
            mediaPlayer.setVolume(0f, 0f) // mute video
        }
        videoView.start()

        // Handle Get Started button click
        btnGetStarted.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        videoView.start()
    }

    override fun onPause() {
        super.onPause()
        videoView.pause()
    }
}
