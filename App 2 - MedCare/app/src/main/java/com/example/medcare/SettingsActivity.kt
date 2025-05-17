package com.example.medcare

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var itemProfileSettings: TextView
    private lateinit var itemNotificationPrefs: TextView
    private lateinit var itemEmergencyInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Initialize TextViews
        itemProfileSettings = findViewById(R.id.itemProfileSettings)
        itemNotificationPrefs = findViewById(R.id.itemNotificationPrefs)
        itemEmergencyInfo = findViewById(R.id.itemEmergencyInfo)

        // Set click listeners for TextView items
        itemProfileSettings.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        itemNotificationPrefs.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }

        itemEmergencyInfo.setOnClickListener {
            val intent = Intent(this, EmergencyActivity::class.java)
            startActivity(intent)
        }

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