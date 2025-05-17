package com.example.medcare

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

class PillboxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pillbox)

        val addMedicationButton: Button = findViewById(R.id.btnLogout)
        addMedicationButton.setOnClickListener {
            // Navigate to MedicationSetupActivity
            val intent = Intent(this, MedicationSetupActivity::class.java)
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