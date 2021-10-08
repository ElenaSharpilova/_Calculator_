package android.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var editFirst: EditText
    lateinit var editSecond: EditText
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
            val res1 = editFirst.text.toString().toDouble()
            val res2 = editSecond.text.toString().toDouble()
            addition(res1, res2)
        }

        btnMinus.setOnClickListener {
            val res1 = editFirst.text.toString().toDouble()
            val res2 = editSecond.text.toString().toDouble()
            subtraction(res1, res2)
        }

        btnMultiply.setOnClickListener {
            val res1 = editFirst.text.toString().toDouble()
            val res2 = editSecond.text.toString().toDouble()
            multiplication(res1, res2)
        }

        btnDivision.setOnClickListener {
            val res1 = editFirst.text.toString().toDouble()
            val res2 = editSecond.text.toString().toDouble()
            division(res1, res2)
        }

    }

    private fun addition (res1: Double, res2: Double) {
        val result = res1 + res2
        intentStartNewActivity(result.toString())

    }

    private fun subtraction (res1: Double, res2: Double) {
        val result = res1 - res2
        intentStartNewActivity(result.toString())

    }

    private fun multiplication (res1: Double, res2: Double) {
        val result = res1 * res2
        intentStartNewActivity(result.toString())

    }

    private fun division (res1: Double, res2: Double) {
        val result = res1 / res2
        intentStartNewActivity(result.toString())

    }

    fun intentStartNewActivity(result: String){
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }
}

