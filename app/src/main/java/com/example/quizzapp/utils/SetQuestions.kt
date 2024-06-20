package com.example.quizzapp.utils

import android.widget.ImageView
import android.widget.TextView
import com.example.quizzapp.model.QuestionModel

class SetQuestions() {

    private var currentQuestionElement: Int = 0
    private lateinit var currentQuestion: QuestionModel
    private var isCurrentQuestionAnswered = false

    fun setQuestions(
        flag: ImageView, listOfOptions: List<TextView>
    ) {
        val questionsList = Constant.getQuestions()
        currentQuestion = questionsList[currentQuestionElement]

        flag.setImageResource(currentQuestion.flag)

        listOfOptions[0].text = currentQuestion.option1
        listOfOptions[1].text = currentQuestion.option2
        listOfOptions[2].text = currentQuestion.option3
        listOfOptions[3].text = currentQuestion.option4

        isCurrentQuestionAnswered = false
    }

    fun getCurrentQuestion(): QuestionModel {
        return currentQuestion
    }

    fun setIsCurrentQuestionAnswered(value: Boolean) {
        isCurrentQuestionAnswered = value
    }

    fun getIsCurrentQuestionAnswered(): Boolean {
        return isCurrentQuestionAnswered
    }

    fun getCurrentQuestionElement(): Int {
        return currentQuestionElement
    }

    fun nextQuestion(flag: ImageView, listOfOptions: List<TextView>) {
            currentQuestionElement++
            setQuestions(flag, listOfOptions)
    }
}