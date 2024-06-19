package com.example.quizzapp.utils

import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizzapp.R
import com.example.quizzapp.activities.QuestionsActivity

class OptionsVisuals(private val listOfOptions: List<TextView>): View.OnClickListener {
    private fun selectedOption(v: View?) {

        when (v?.id) {
            R.id.option1 -> {
                selectedOptionVisual(listOfOptions[0])
            }
            R.id.option2 -> {
                selectedOptionVisual(listOfOptions[1])
            }
            R.id.option3 -> {
                selectedOptionVisual(listOfOptions[2])
            }
            R.id.option4 -> {
                selectedOptionVisual(listOfOptions[3])
            }
        }

    }

    private fun selectedOptionVisual(option: TextView) {
        option.setTextColor(Color.parseColor("#9909E8"))
        option.setTypeface(option.typeface, Typeface.BOLD)
        option.background = ContextCompat.getDrawable(
            option.context,
            R.drawable.selected_border_bg
        )
    }

    override fun onClick(v: View?) {
        selectedOption(v)
    }
}