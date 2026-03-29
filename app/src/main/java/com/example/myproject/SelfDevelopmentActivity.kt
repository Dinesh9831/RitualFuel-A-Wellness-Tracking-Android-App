package com.example.myproject

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SelfDevelopmentActivity : AppCompatActivity() {
    private val quotes = listOf(
        "The only way to do great work is to love what you do.",
        "Change is the end result of all true learning.",
        "Don’t wish for it, work for it."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_self_development)

        val qv = findViewById<TextView>(R.id.quoteTextView)
        val btn = findViewById<Button>(R.id.copyButton)
        qv.text = quotes.random()
        btn.setOnClickListener {
            copyToClipboard("Self Development Quote", qv.text.toString())
        }

        setupImageClicks()
    }

    private fun copyToClipboard(label: String, text: String) {
        (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager)
            .setPrimaryClip(ClipData.newPlainText(label, text))
    }

    private fun setupImageClicks() {
        val drawableIds = listOf(
            R.drawable.img_28, R.drawable.img_29, R.drawable.img_30,
            R.drawable.img_31, R.drawable.img_32, R.drawable.img_33
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