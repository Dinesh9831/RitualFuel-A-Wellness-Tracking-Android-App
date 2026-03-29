package com.example.myproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class YogaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga)

        val suryaBtn = findViewById<ImageButton>(R.id.surya)
        suryaBtn.setOnClickListener {
            val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/1xRX1MuoImw?si=cR0148Q38goN4q1G"))
            startActivity(youtubeIntent)
        }

        val bhuBtn = findViewById<ImageButton>(R.id.bhuj)
        bhuBtn.setOnClickListener {
            val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/UYDTHxVh2EE?si=y9yXflkA2T3fAOi5"))
            startActivity(youtubeIntent)
        }

        val tadBtn = findViewById<ImageButton>(R.id.tada)
        tadBtn.setOnClickListener {
            val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/3UdD38Pt2-c?si=5bQPrz3wiT_zWvF1"))
            startActivity(youtubeIntent)
        }
        val savBtn = findViewById<ImageButton>(R.id.sava)

        savBtn.setOnClickListener {
            val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/G_sy6JQieXg?si=HONboFr5hbRMW4zy"))
            startActivity(youtubeIntent)
        }
        val bridgeBtn = findViewById<ImageButton>(R.id.brid)

        bridgeBtn.setOnClickListener {
            val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iyICFOpj9LY?si=kO5s-ybkhNbOewcG"))
            startActivity(youtubeIntent)
        }
        val virBtn = findViewById<ImageButton>(R.id.vira)

        virBtn.setOnClickListener {
            val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/kkGY3xBnaGc?si=4SX3NIlwQnluoiLq")) // Replace with your Warrior Pose video
            startActivity(youtubeIntent)
        }

    }
}