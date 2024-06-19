package com.example.quizzapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizzapp.activities.QuestionsActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameInput: TextInputEditText
    private lateinit var startBtn: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            insets
        }

        startBtn = findViewById(R.id.start_btn)
        nameInput = findViewById(R.id.name_input)

        startBtn.setOnClickListener {
            val name = nameInput.text.toString()

            if(name.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
            else {
                Intent(this@MainActivity, QuestionsActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}