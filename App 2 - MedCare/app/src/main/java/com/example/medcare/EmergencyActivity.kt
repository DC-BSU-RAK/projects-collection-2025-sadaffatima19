package com.example.medcare

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EmergencyActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var nameTextView: TextView
    private lateinit var dobTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        // Initialize views
        nameTextView = findViewById(R.id.emergencyName)
        dobTextView = findViewById(R.id.emergencyDOB)

        // Load SharedPreferences
        sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE)

        val name = sharedPreferences.getString("name", "Not Set")
        val dob = sharedPreferences.getString("dob", "Not Set")

        nameTextView.text = "$name"
        dobTextView.text = "$dob"

        // Bottom navigation
        findViewById<ImageView>(R.id.iconHome).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        findViewById<ImageView>(R.id.iconNotifications).setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
            finish()
        }

        findViewById<ImageView>(R.id.iconUser).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }

        findViewById<ImageView>(R.id.iconSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
            finish()
        }

        findViewById<ImageView>(R.id.iconPillbox).setOnClickListener {
            startActivity(Intent(this, PillboxActivity::class.java))
            finish()
        }
    }
}