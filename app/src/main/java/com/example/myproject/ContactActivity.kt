package com.example.myproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val troubleshootItems = listOf(
            Pair(R.id.troubleshoot1, R.id.answer1),
            Pair(R.id.troubleshoot2, R.id.answer2),
            Pair(R.id.troubleshoot3, R.id.answer3),
            Pair(R.id.troubleshoot4, R.id.answer4),
            Pair(R.id.troubleshoot5, R.id.answer5)
        )

        troubleshootItems.forEach { (questionId, answerId) ->
            val question = findViewById<TextView>(questionId)
            val answer = findViewById<TextView>(answerId)
            question.setOnClickListener {
                answer.visibility = if (answer.visibility == View.GONE) View.VISIBLE else View.GONE
            }
        }

        val email = findViewById<TextView>(R.id.contact_email)
        email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:moturisaidinesh@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "App Support")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show()
            }
        }

        val phone = findViewById<TextView>(R.id.contact_phone)
        phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:9390107209")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "No dialer app found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
