package com.example.quizzapp.visuals

import android.widget.ProgressBar
import android.widget.TextView
import com.example.quizzapp.utils.SetQuestions

class ProgressBarVisuals(
    private val progressBar: ProgressBar,
    private val setQuestions: SetQuestions,
    private val progressBarText: TextView
) {
    fun updateProgressBarVisuals() {
        val progress = setQuestions.getCurrentQuestionElement() + 1
        progressBar.progress = progress

        progressBarText.text = "$progress / ${progressBar.max}"
    }
}