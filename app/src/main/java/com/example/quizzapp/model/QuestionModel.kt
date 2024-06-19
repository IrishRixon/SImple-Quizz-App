package com.example.quizzapp.model

data class QuestionModel(
    val id: Int,
    val flag: Int,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAns: Int
)
