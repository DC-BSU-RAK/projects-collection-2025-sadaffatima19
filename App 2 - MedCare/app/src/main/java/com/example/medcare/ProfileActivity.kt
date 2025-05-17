package com.example.medcare

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import android.widget.EditText

class ProfileActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var dobTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var logoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Initialize views
        nameTextView = findViewById(R.id.nameValue)
        dobTextView = findViewById(R.id.dobValue)
        phoneTextView = findViewById(R.id.phoneValue)
        emailTextView = findViewById(R.id.emailValue)
        logoutButton = findViewById(R.id.btnLogout)

        // Load user profile info from SharedPreferences
        val sharedPreferences = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "Not set")
        val dob = sharedPreferences.getString("dob", "Not set")
        val phone = sharedPreferences.getString("phone", "Not set")
        val email = sharedPreferences.getString("email", "Not set")

        // Set texts
        nameTextView.text = name
        dobTextView.text = dob
        phoneTextView.text = phone
        emailTextView.text = email

        // Logout button action
        logoutButton.setOnClickListener {
            sharedPreferences.edit {
                clear()
            }
            startActivity(Intent(this, SplashActivity::class.java))
            finish()
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
            Toast.makeText(this, "You're already on the profile screen", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.iconSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
            finish()
        }

        findViewById<ImageView>(R.id.iconPillbox).setOnClickListener {
            startActivity(Intent(this, PillboxActivity::class.java))
            finish()
        }

        val editButton = findViewById<Button>(R.id.btnEditProfile)
        editButton.setOnClickListener {
            showEditProfileDialog()
        }
    }

    private fun showEditProfileDialog() {
        val sharedPreferences = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)

        val dialogView = layoutInflater.inflate(R.layout.dialog_edit_profile, null)
        val editName = dialogView.findViewById<EditText>(R.id.editName)
        val editDob = dialogView.findViewById<EditText>(R.id.editDob)
        val editEmail = dialogView.findViewById<EditText>(R.id.editEmail)
        val editPhone = dialogView.findViewById<EditText>(R.id.editPhone)

        // Pre-fill fields with existing data
        editName.setText(sharedPreferences.getString("name", ""))
        editDob.setText(sharedPreferences.getString("dob", ""))
        editEmail.setText(sharedPreferences.getString("email", ""))
        editPhone.setText(sharedPreferences.getString("phone", ""))

        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Edit Profile")
        builder.setView(dialogView)
        builder.setPositiveButton("Save") { _, _ ->
            val name = editName.text.toString().trim()
            val dob = editDob.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val phone = editPhone.text.toString().trim()

            if (name.isBlank() || dob.isBlank() || email.isBlank() || phone.isBlank()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setPositiveButton
            }

            // Save to SharedPreferences
            sharedPreferences.edit().apply {
                putString("name", name)
                putString("dob", dob)
                putString("email", email)
                putString("phone", phone)
                apply()
            }

            // Update the UI
            nameTextView.text = name
            dobTextView.text = dob
            emailTextView.text = email
            phoneTextView.text = phone

            Toast.makeText(this, "Profile updated!", Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton("Cancel", null)
        builder.create().show()
    }
}