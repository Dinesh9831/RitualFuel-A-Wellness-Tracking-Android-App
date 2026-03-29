package com.example.myproject

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Main : AppCompatActivity() {

    private lateinit var historyText: LinearLayout
    private lateinit var geoText: LinearLayout
    private lateinit var politicsText: LinearLayout
    private lateinit var currentAffairsText: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gk)

        historyText = findViewById(R.id.historyText)
        geoText = findViewById(R.id.geoText)
        politicsText = findViewById(R.id.politicsText)
        currentAffairsText = findViewById(R.id.currentAffairsText)

        historyText.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        geoText.setOnClickListener {
            startActivity(Intent(this, GeographyActivity::class.java))
        }

        politicsText.setOnClickListener {
            startActivity(Intent(this, PoliticsActivity::class.java))
        }

        currentAffairsText.setOnClickListener {
            startActivity(Intent(this, CurrentAffairsActivity::class.java))
        }
    }
}
