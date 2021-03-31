package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner: Spinner = findViewById(R.id.operator_spinner)
        val operators = resources.getStringArray(R.array.operator_array)
        var operation: String = "+"
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                    android.R.layout.simple_spinner_item, operators)
            spinner.adapter = adapter
            val result: Button = findViewById(R.id.result_button)

            spinner.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long
                ) {
                    operation = operators[position].toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
            result.setOnClickListener { calculate(operation) }
        }
    }

    private fun calculate(operation: String ) {

        val firstnumber: EditText = findViewById(R.id.value1)
        val secondnumber: EditText = findViewById(R.id.value2)
        val resultNo: TextView = findViewById(R.id.result_number)

        when(operation) {
            "+" -> {
                var res: Int =
                        firstnumber.text.toString().toInt() + secondnumber.text.toString().toInt()
                resultNo.text = res.toString()
            }
            "-" -> {
                var res: Int =
                        firstnumber.text.toString().toInt() - secondnumber.text.toString().toInt()
                resultNo.text = res.toString()
            }
            "/" -> {
                var res: Int =
                        firstnumber.text.toString().toInt() / secondnumber.text.toString().toInt()
                resultNo.text = res.toString()
            }
            "*" -> {
                var res: Int =
                        firstnumber.text.toString().toInt() * secondnumber.text.toString().toInt()
                resultNo.text = res.toString()

            }
        }

    }
}