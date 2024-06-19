package com.example.quizzapp.utils

import android.widget.ImageView
import android.widget.TextView

class SetQuestions {

    private val currentQuestionElement = 1

    fun setQuestions(
        flag: ImageView, option1: TextView, option2: TextView,
        option3: TextView, option4: TextView
    ) {
        val questionsList = Constant.getQuestions()
        val currentQuestion = questionsList[currentQuestionElement]

        flag.setImageResource(currentQuestion.flag)
        option1.text = currentQuestion.option1
        option2.text = currentQuestion.option2
        option3.text = currentQuestion.option3
        option4.text = currentQuestion.option4
    }
}