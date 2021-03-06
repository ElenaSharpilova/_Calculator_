package android.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var editFirst: EditText
    private lateinit var editSecond: EditText
    lateinit var btnPlus: Button
    lateinit var btnMultiply: Button
    lateinit var btnMinus: Button
    lateinit var btnDivision: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editFirst = findViewById(R.id.et_1)
        editSecond = findViewById(R.id.et_2)
        btnPlus = findViewById(R.id.btn_plus)
        btnMinus = findViewById(R.id.btn_minus)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnDivision = findViewById(R.id.btn_division)


        btnPlus.setOnClickListener {
            val res1 = editFirst.text.toString()
            val res2 = editSecond.text.toString()

            if (res1.equals("") || res2.equals("")) {
                Toast.makeText(this, "Please, enter numbers", Toast.LENGTH_LONG).show()
            } else {
                addition(res1.toFloat(), res2.toFloat())
            }
        }

        btnMinus.setOnClickListener {
            val res1 = editFirst.text.toString()
            val res2 = editSecond.text.toString()
            if (res1.equals("") || res2.equals("")) {
                Toast.makeText(this, "Please, enter numbers", Toast.LENGTH_LONG).show()
            } else {
               subtraction(res1.toFloat(), res2.toFloat())
            }

        }

        btnMultiply.setOnClickListener {
            val res1 = editFirst.text.toString()
            val res2 = editSecond.text.toString()
            if (res1.equals("") || res2.equals("")) {
                Toast.makeText(this, "Please, enter numbers", Toast.LENGTH_LONG).show()
            } else {
                multiplication(res1.toFloat(), res2.toFloat())
            }
        }

        btnDivision.setOnClickListener {
            val res1 = editFirst.text.toString()
            val res2 = editSecond.text.toString()
            if (res1.equals("") || res2.equals("")) {
                Toast.makeText(this, "Please, enter numbers", Toast.LENGTH_LONG).show()
            } else if (res1.toDouble() == 0.0 || res2.toDouble() == 0.0) {
                Toast.makeText(this, "You cannot divided by zero", Toast.LENGTH_LONG).show()
            } else {
            division(res1.toDouble(), res2.toDouble())
            }
        }
    }

    private fun addition (res1: Float, res2: Float) {
        val result = res1 + res2
        intentStartNewActivity(result.toString())

    }

    private fun subtraction (res1: Float, res2: Float) {
        val result = res1 - res2
        intentStartNewActivity(result.toString())

    }

    private fun multiplication (res1: Float, res2: Float) {
        val result = res1 * res2
        intentStartNewActivity(result.toString())

    }

    private fun division (res1: Double, res2: Double) {
        val result = res1 / res2
        val _result = DecimalFormat("#.##")
        _result.roundingMode = RoundingMode.CEILING
        intentStartNewActivity(_result.format(result).toString())
    }

    private fun intentStartNewActivity(result: String){
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }
}

