package com.example.quizzapp.utils

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.quizzapp.model.QuestionModel
import com.google.android.material.button.MaterialButton
import com.example.quizzapp.utils.OptionsVisuals

class CheckAnswer(
    private val listOfOptions: List<TextView>,
    checkBtn: MaterialButton,
    private val optionsVisuals: OptionsVisuals,
    private val flag: ImageView,
    private val setQuestions: SetQuestions,
) {
    init {
        checkBtn.setOnClickListener {
            val currentQuestion = setQuestions.getCurrentQuestion()

            if (!setQuestions.getIsCurrentQuestionAnswered()) {
                setQuestions.setIsCurrentQuestionAnswered(true)
                checkBtn.text = "Next"

                if (optionsVisuals.getSelectedOption() == listOfOptions[currentQuestion.correctAns - 1]) {
                    optionsVisuals.correctAnswerVisual(optionsVisuals.getSelectedOption())
                } else {
                    optionsVisuals.wrongAnswerVisual(optionsVisuals.getSelectedOption())
                    optionsVisuals.correctAnswerVisual(listOfOptions[currentQuestion.correctAns - 1])
                }
            } else {
                val cons = Constant.getQuestions().size - 1
                Log.d("Check", "${setQuestions.getCurrentQuestionElement()} size: $cons")
                if (setQuestions.getCurrentQuestionElement() < Constant.getQuestions().size - 1) {
                    optionsVisuals.resetVisuals()
                    setQuestions.nextQuestion(flag, listOfOptions)
                    checkBtn.text = "Check"
                } else {
                    val cons = Constant.getQuestions().size - 1
                    Log.d("Check", "${setQuestions.getCurrentQuestionElement()} size: $cons")
                }
            }
        }
    }
}