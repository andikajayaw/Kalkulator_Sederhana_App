package com.andikajayaw.kalkulatorsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var OPERATOR: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpListener()
    }

    private fun validate(): Boolean {
        if(editValue1.text.isNullOrEmpty() || editValue2.text.isNullOrEmpty()) {
            return false
        } else if(OPERATOR.isNullOrEmpty()) {
            return false
        }
        return true
    }

    private fun calculator(val1: Int, val2: Int): String {
        var result: Int = 0
        when(OPERATOR) {
            "+" -> result = val1 + val2
            "-" -> result = val1 - val2
            "X" -> result = val1 * val2
            "/" -> result = val1 / val2
        }
        return result.toString()
    }

    private fun setUpListener() {
        radioGroup.setOnCheckedChangeListener { group, _ ->
            val radioButton = findViewById<RadioButton>(group.checkedRadioButtonId)
            OPERATOR = radioButton.text.toString()
            textResult.text = "0"

        }
        btnCalculator.setOnClickListener {
            if(validate()) {
                val val1: Int = editValue1.text.toString().toInt()
                val val2: Int = editValue2.text.toString().toInt()
                textResult.text = calculator(val1, val2)
            } else {
                showMessage("Data tidak benar")
            }
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}