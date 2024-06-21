package com.example.quizzapp.utils

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.example.quizzapp.visuals.OptionsVisuals
import com.example.quizzapp.visuals.ProgressBarVisuals

class CheckAnswer(
    private val listOfOptions: List<TextView>,
    checkBtn: MaterialButton,
    private val optionsVisuals: OptionsVisuals,
    private val flag: ImageView,
    private val setQuestions: SetQuestions,
    private val progressBarVisuals: ProgressBarVisuals,
    toast: () -> Unit
) {
    init {
        checkBtn.setOnClickListener {
            val currentQuestion = setQuestions.getCurrentQuestion()

            if (optionsVisuals.getSelectedOption() == null) {
                toast()
            }
            else if (!setQuestions.getIsCurrentQuestionAnswered()) {
                setQuestions.setIsCurrentQuestionAnswered(true)
                checkBtn.text = "Next"
                optionsVisuals.disableClickable()

                if (optionsVisuals.getSelectedOption() == listOfOptions[currentQuestion.correctAns - 1]) {
                    optionsVisuals.correctAnswerVisual(optionsVisuals.getSelectedOption()!!)
                } else {
                    optionsVisuals.wrongAnswerVisual(optionsVisuals.getSelectedOption()!!)
                    optionsVisuals.correctAnswerVisual(listOfOptions[currentQuestion.correctAns - 1])
                }
            } else {
                if (setQuestions.getCurrentQuestionElement() < Constant.getQuestions().size - 1) {
                    optionsVisuals.resetVisuals()
                    optionsVisuals.resetSelectedOption()

                    setQuestions.nextQuestion(flag, listOfOptions)

                    progressBarVisuals.updateProgressBarVisuals()

                    optionsVisuals.enableClickable()

                    checkBtn.text = "Check"
                } else {
                    Log.d("Check", "${setQuestions.getCurrentQuestionElement()}")
                }
            }
        }
    }
}