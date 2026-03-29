package com.example.myproject

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HealthActivity : AppCompatActivity() {
    private val quotes = listOf(
        "Health is wealth.",
        "Take care of your body—they’re the only place you have to live.",
        "Good health is a state of harmony."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health)


        val qv = findViewById<TextView>(R.id.quoteTextView)
        val btn = findViewById<Button>(R.id.copyButton)
        val quote = quotes.random()
        qv.text = quote
        btn.setOnClickListener {
            copyToClipboard("Health Quote", quote)
        }


        setupImageClicks()
    }

    private fun copyToClipboard(label: String, text: String) {
        val manager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        manager.setPrimaryClip(ClipData.newPlainText(label, text))
    }

    private fun setupImageClicks() {
        val drawableIds = listOf(R.drawable.img_15, R.drawable.img_14, R.drawable.img_13,
            R.drawable.img_12, R.drawable.img_11, R.drawable.img_10)

        for (i in 1..6) {
            val iv = findViewById<ImageView>(resources.getIdentifier("image$i", "id", packageName))
            val resId = drawableIds[i - 1]
            iv.setOnClickListener {
                val uri = "android.resource://$packageName/$resId"
                copyToClipboard("Image URI", uri)
            }
        }
    }
}
