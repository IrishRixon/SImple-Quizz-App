package com.example.quizzapp.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizzapp.R
import com.example.quizzapp.utils.CheckAnswer
import com.example.quizzapp.visuals.OptionsVisuals
import com.example.quizzapp.visuals.ProgressBarVisuals
import com.example.quizzapp.utils.SetQuestions
import com.google.android.material.button.MaterialButton

class QuestionsActivity : AppCompatActivity() {

    private lateinit var listOfOptions: List<TextView>

    //Views
    private lateinit var flag: ImageView
    private lateinit var option1: TextView
    private lateinit var option2: TextView
    private lateinit var option3: TextView
    private lateinit var option4: TextView
    private lateinit var checkBtn: MaterialButton
    private lateinit var progressBar: ProgressBar
    private lateinit var progressBarText: TextView

    //Objects
    private lateinit var setQuestions: SetQuestions
    private lateinit var checkAnswer: CheckAnswer
    private lateinit var progressBarVisuals: ProgressBarVisuals

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            insets
        }

        flag = findViewById(R.id.flag)

        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        checkBtn = findViewById(R.id.check_btn)
        progressBar = findViewById(R.id.progress_bar)

        listOfOptions = listOf(option1, option2, option3, option4)

        // Set questions
        setQuestions = SetQuestions()
        setQuestions.setQuestions(flag, listOfOptions)

        progressBarText = findViewById(R.id.progress_text)
        progressBarVisuals = ProgressBarVisuals(progressBar, setQuestions, progressBarText)

        val optionsVisuals = OptionsVisuals()
        optionsVisuals.listOfOptions = listOfOptions
        checkAnswer =
            CheckAnswer(listOfOptions, checkBtn, optionsVisuals, flag, setQuestions, progressBarVisuals) {
                Toast.makeText(
                    this,
                    "Please select your answer",
                    Toast.LENGTH_SHORT
                ).show()
            }

        for (option in listOfOptions) {
            option.setOnClickListener(optionsVisuals)
        }
    }
}
