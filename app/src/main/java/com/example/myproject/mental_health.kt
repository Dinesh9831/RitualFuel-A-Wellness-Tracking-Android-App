package com.example.myproject
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class mental_health : AppCompatActivity() {
    private val quotes = listOf(
        "Your mental health is a priority.",
        "It’s okay to not be okay.",
        "Healing takes time."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mental_health)

        val qv = findViewById<TextView>(R.id.quoteTextView)
        val btn = findViewById<Button>(R.id.copyButton)
        qv.text = quotes.random()
        btn.setOnClickListener {
            copyToClipboard("Mental Health Quote", qv.text.toString())
        }

        setupImageClicks()
    }

    private fun copyToClipboard(label: String, text: String) {
        (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager)
            .setPrimaryClip(ClipData.newPlainText(label, text))
    }

    private fun setupImageClicks() {
        val drawableIds = listOf(
            R.drawable.img_16, R.drawable.img_17, R.drawable.img_18,
            R.drawable.img_19, R.drawable.img_20, R.drawable.img_21
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

