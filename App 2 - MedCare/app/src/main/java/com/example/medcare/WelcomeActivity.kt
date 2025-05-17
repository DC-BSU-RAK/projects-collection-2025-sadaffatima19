package com.example.medcare

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Get the "Get Started" button
        val getStartedBtn: Button = findViewById(R.id.getStartedBtn)

        // Set an OnClickListener for the button
        getStartedBtn.setOnClickListener {
            // Transition to User Profile Setup (next screen)
            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }

        // Find the Instructions button
        val instructionsBtn: Button = findViewById(R.id.instructionsBtn)

        // Set an OnClickListener to show the instructions dialog
        instructionsBtn.setOnClickListener {
            // Inflate the custom dialog layout
            val dialogView = layoutInflater.inflate(R.layout.dialog_instructions, null)

            // Create AlertDialog builder
            val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(this)
                .setView(dialogView)

            // Create and show the dialog
            val alertDialog = dialogBuilder.create()
            alertDialog.show()

            // Find the close button inside dialog and dismiss dialog when clicked
            val closeBtn: Button = dialogView.findViewById(R.id.closeInstructionsBtn)
            closeBtn.setOnClickListener {
                alertDialog.dismiss()
            }
        }
    }
}