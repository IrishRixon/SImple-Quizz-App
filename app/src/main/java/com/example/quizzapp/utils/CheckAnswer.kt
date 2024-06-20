package com.example.quizzapp.utils

import android.widget.TextView
import com.example.quizzapp.model.QuestionModel
import com.google.android.material.button.MaterialButton
import com.example.quizzapp.utils.OptionsVisuals

class CheckAnswer(
    private val listOfOptions: List<TextView>,
    checkBtn: MaterialButton,
    private val optionsVisuals: OptionsVisuals,
    private val currentQuestion: QuestionModel
    ) {
    init {
        checkBtn.setOnClickListener {
            if(optionsVisuals.getSelectedOption() == listOfOptions[currentQuestion.correctAns - 1]) {
                optionsVisuals.correctAnswerVisual(optionsVisuals.getSelectedOption())
            } else {
                optionsVisuals.wrongAnswerVisual(optionsVisuals.getSelectedOption())
                optionsVisuals.correctAnswerVisual(listOfOptions[currentQuestion.correctAns - 1])
            }
        }
    }
}