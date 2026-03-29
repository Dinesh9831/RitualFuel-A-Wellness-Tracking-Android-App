package com.example.myproject


import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        findViewById<LinearLayout>(R.id.mentalHealthLayout).setOnClickListener {
            startActivity(Intent(this, mental_health::class.java))
        }

        findViewById<LinearLayout>(R.id.motivationLayout).setOnClickListener {
            startActivity(Intent(this, MotivationActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.selfDevLayout).setOnClickListener {
            startActivity(Intent(this, SelfDevelopmentActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.healthLayout).setOnClickListener {
            startActivity(Intent(this, HealthActivity::class.java))
        }
    }
}