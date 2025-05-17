package com.example.complimentgenerator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils

class MainActivity : AppCompatActivity() {

    private lateinit var moodSpinner: Spinner
    private lateinit var colorSpinner: Spinner
    private lateinit var initialsInput: EditText
    private lateinit var generateButton: Button
    private lateinit var complimentText: TextView
    private lateinit var flowerImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        moodSpinner = findViewById(R.id.moodSpinner)
        colorSpinner = findViewById(R.id.colorSpinner)
        initialsInput = findViewById(R.id.initialsInput)
        generateButton = findViewById(R.id.generateButton)
        complimentText = findViewById(R.id.complimentText)
        flowerImage = findViewById(R.id.flowerImage)
        val infoButton: ImageButton = findViewById(R.id.infoButton)

        // Info Button Click
        infoButton.setOnClickListener {
            showInfoDialog()
        }

        // Generate Button Click
        generateButton.setOnClickListener {
            val initials = initialsInput.text.toString()
            val compliment = generateCompliment(initials)

            complimentText.text = compliment
            complimentText.visibility = View.VISIBLE
            flowerImage.visibility = View.VISIBLE

            // Animation
            val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            complimentText.startAnimation(fadeIn)
            flowerImage.startAnimation(fadeIn)
        }
    }

    private fun generateCompliment(initials: String): String {
        val compliments = listOf(
            "You're a ray of sunshine ☀️",
            "Your smile brightens up the day 😊",
            "You're blooming beautifully 🌸",
            "You're strong, capable, and amazing 💪",
            "The world is better with you in it 🌍",
            "You sparkle even on cloudy days ✨",
            "You’re doing better than you think ❤️",
            "You have a heart of gold 💛"
        )

        val randomCompliment = compliments.random()
        return if (initials.isNotEmpty()) "$randomCompliment, $initials!" else randomCompliment
    }

    private fun showInfoDialog() {
        AlertDialog.Builder(this)
            .setTitle("How It Works")
            .setMessage("Choose a mood and a favorite color, then tap the button to receive a personalized compliment!")
            .setPositiveButton("OK", null)
            .show()
    }
}