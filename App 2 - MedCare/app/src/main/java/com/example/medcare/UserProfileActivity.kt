package com.example.medcare

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        // Initialize views with correct IDs
        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val dobEditText: EditText = findViewById(R.id.dobEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val phoneEditText: EditText = findViewById(R.id.phoneEditText)
        val genderSpinner: Spinner = findViewById(R.id.genderSpinner)
        val continueButton: Button = findViewById(R.id.continueButton)

        // Gender options
        val genderOptions = arrayOf("Male", "Female")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = adapter

        // Handle Continue button click
        continueButton.setOnClickListener {
            // Get user input
            val name = nameEditText.text.toString().trim()
            val dob = dobEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val gender = genderSpinner.selectedItem.toString()

            // Basic validation
            if (name.isBlank() || dob.isBlank() || email.isBlank() || phone.isBlank()) {
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save the data using SharedPreferences
            val sharedPreferences: SharedPreferences = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.putString("name", name)
            editor.putString("dob", dob)
            editor.putString("email", email)
            editor.putString("phone", phone)
            editor.putString("gender", gender)
            editor.apply()

            Toast.makeText(this, "Profile saved successfully!", Toast.LENGTH_SHORT).show()

            // Move to next activity
            startActivity(Intent(this, MedicationSetupActivity::class.java))
            finish()
        }
    }
}