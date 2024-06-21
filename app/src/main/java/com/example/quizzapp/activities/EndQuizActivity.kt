package com.example.quizzapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizzapp.MainActivity
import com.example.quizzapp.R
import com.google.android.material.button.MaterialButton

class EndQuizActivity : AppCompatActivity() {

    private lateinit var greeting: TextView
    private lateinit var score: TextView
    private lateinit var mainMenu: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_end_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            insets
        }

        greeting = findViewById(R.id.greeting)
        score = findViewById(R.id.score)
        mainMenu = findViewById(R.id.main_menu)

        greeting.text = "Congratulations, ${intent.getStringExtra("name")}!"
        score.text = "Your score is ${intent.getIntExtra("score", 0)} / 4"

        mainMenu.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}