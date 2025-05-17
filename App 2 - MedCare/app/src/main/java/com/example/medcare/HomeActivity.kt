package com.example.medcare

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Load user name from SharedPreferences
        val sharedPreferences = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "User") ?: "User"
        val welcomeText: TextView = findViewById(R.id.welcomeText)
        welcomeText.text = "Hi, $name"

        // Bottom Navigation

        val iconHome = findViewById<ImageView>(R.id.iconHome)
        iconHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        val iconNotifications = findViewById<ImageView>(R.id.iconNotifications)
        iconNotifications.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.iconSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
            finish()
        }

        findViewById<ImageView>(R.id.iconPillbox).setOnClickListener {
            startActivity(Intent(this, PillboxActivity::class.java))
            finish()
        }

        val iconUserBottom: ImageView = findViewById(R.id.iconUserBottom)

        val profileIntent = Intent(this, ProfileActivity::class.java)
        iconUserBottom.setOnClickListener {
            startActivity(profileIntent)
        }
    }
}