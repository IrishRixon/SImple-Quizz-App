package com.example.quizzapp.utils

import com.example.quizzapp.R
import com.example.quizzapp.activities.Questions
import com.example.quizzapp.model.QuestionModel

object Constant {
    fun getQuestions(): MutableList<QuestionModel> {
        val questionsList = mutableListOf<QuestionModel>()

        val question1 = QuestionModel(
            R.drawable.afghanistan,
            "Albania",
            "Algeria",
            "Afghanistan",
            "Armenia",
            3
        )
        questionsList.add(question1)

        val question2 = QuestionModel(
            R.drawable.andorra,
            "Albania",
            "Algeria",
            "Afghanistan",
            "Andorra",
            4
        )
        questionsList.add(question2)

        val question3 = QuestionModel(
            R.drawable.albania,
            "Albania",
            "Algeria",
            "Afghanistan",
            "Armenia",
            1
        )

        questionsList.add(question3)
        val question4 = QuestionModel(
            R.drawable.algeria,
            "Albania",
            "Algeria",
            "Afghanistan",
            "Armenia",
            2
        )
        questionsList.add(question4)

        return questionsList
    }
}