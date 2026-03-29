package com.example.myproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GeographyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.geo) // ✅ Fix: use correct layout file name
    }
}