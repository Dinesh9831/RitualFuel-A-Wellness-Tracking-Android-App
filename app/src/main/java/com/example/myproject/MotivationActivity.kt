package com.example.myproject

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MotivationActivity : AppCompatActivity() {
    private val quotes = listOf(
        "Push yourself, because no one else is going to do it for you.",
        "Success is not for the lazy.",
        "Dream it. Wish it. Do it."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motivation)

        val qv = findViewById<TextView>(R.id.quoteTextView)
        val btn = findViewById<Button>(R.id.copyButton)
        val quote = quotes.random()
        qv.text = quote
        btn.setOnClickListener {
            copyToClipboard("Motivation Quote", quote)
        }

        setupImageClicks()
    }

    private fun copyToClipboard(label: String, text: String) {
        (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager)
            .setPrimaryClip(ClipData.newPlainText(label, text))
    }

    private fun setupImageClicks() {
        val drawableIds = listOf(
            R.drawable.img_22, R.drawable.img_23, R.drawable.img_24,
            R.drawable.img_25, R.drawable.img_26, R.drawable.img_27
        )
        for (i in 1..6) {
            findViewById<ImageView>(
                resources.getIdentifier("image$i", "id", packageName)
            ).setOnClickListener {
                val uri = "android.resource://$packageName/${drawableIds[i-1]}"
                copyToClipboard("Image URI", uri)
            }
        }
    }
}
