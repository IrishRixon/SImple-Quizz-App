package com.example.quizzapp.utils

import android.widget.ImageView
import android.widget.TextView

class SetQuestions {

    private val currentQuestionElement = 1

    fun setQuestions(
        flag: ImageView, listOfOptions: List<TextView>
    ) {
        val questionsList = Constant.getQuestions()
        val currentQuestion = questionsList[currentQuestionElement]

        flag.setImageResource(currentQuestion.flag)

        listOfOptions[0].text = currentQuestion.option1
        listOfOptions[1].text = currentQuestion.option2
        listOfOptions[2].text = currentQuestion.option3
        listOfOptions[3].text = currentQuestion.option4
    }
}