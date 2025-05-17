package com.example.medcare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MedicationSetupActivity : AppCompatActivity() {

    private lateinit var medicationNameEditText: EditText
    private lateinit var dosageEditText: EditText
    private lateinit var frequencyEditText: EditText
    private lateinit var timeEditText: EditText
    private lateinit var startDateEditText: EditText
    private lateinit var notesEditText: EditText

    private lateinit var addMedicationButton: Button
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medication_setup)

        // Initialize EditTexts
        medicationNameEditText = findViewById(R.id.medicationNameEditText)
        dosageEditText = findViewById(R.id.dosageEditText)
        frequencyEditText = findViewById(R.id.frequencyEditText)
        timeEditText = findViewById(R.id.timeEditText)
        startDateEditText = findViewById(R.id.startDateEditText)
        notesEditText = findViewById(R.id.notesEditText)

        // Initialize Buttons
        addMedicationButton = findViewById(R.id.addMedicationButton)
        continueButton = findViewById(R.id.continueToHomeButton)

        addMedicationButton.setOnClickListener {
            // Clear all the input fields
            medicationNameEditText.text.clear()
            dosageEditText.text.clear()
            frequencyEditText.text.clear()
            timeEditText.text.clear()
            startDateEditText.text.clear()
            notesEditText.text.clear()

            Toast.makeText(this, "Fields cleared, add your medication!", Toast.LENGTH_SHORT).show()
        }

        continueButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}