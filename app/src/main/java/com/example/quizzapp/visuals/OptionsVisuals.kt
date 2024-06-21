package com.example.quizzapp.visuals

import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizzapp.R

class OptionsVisuals : View.OnClickListener {
    lateinit var listOfOptions: List<TextView>
    private var selectedOption: TextView? = null
    private var isClickable: Boolean = true

    private fun selectedOption(v: View?) {
        when (v?.id) {
            R.id.option1 -> {
                selectedOptionVisual(listOfOptions[0])
                selectedOption = listOfOptions[0]
            }

            R.id.option2 -> {
                selectedOptionVisual(listOfOptions[1])
                selectedOption = listOfOptions[1]
            }

            R.id.option3 -> {
                selectedOptionVisual(listOfOptions[2])
                selectedOption = listOfOptions[2]
            }

            R.id.option4 -> {
                selectedOptionVisual(listOfOptions[3])
                selectedOption = listOfOptions[3]
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

    fun resetVisuals() {
        for (option in listOfOptions) {
            option.setTextColor(Color.parseColor("#FF000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                option.context,
                R.drawable.default_border_bg
            )
        }
    }

    fun correctAnswerVisual(selectedOption: TextView) {
        selectedOption.setTextColor(Color.parseColor("#FF000000"))
        selectedOption.typeface = Typeface.DEFAULT
        selectedOption.background = ContextCompat.getDrawable(
            selectedOption.context,
            R.drawable.correct_border_bg
        )
    }

    fun wrongAnswerVisual(selectedOption: TextView) {
        selectedOption.setTextColor(Color.parseColor("#FF000000"))
        selectedOption.typeface = Typeface.DEFAULT
        selectedOption.background = ContextCompat.getDrawable(
            selectedOption.context,
            R.drawable.wrong_border_bg
        )
    }

    override fun onClick(v: View?) {
        if(isClickable) {
            resetVisuals()
            selectedOption(v)
        }
    }

    fun getSelectedOption(): TextView? {
        return selectedOption
    }
    fun resetSelectedOption() {
        selectedOption = null
    }

    fun enableClickable() {
        isClickable = true
    }
    fun disableClickable() {
        isClickable = false
    }


}