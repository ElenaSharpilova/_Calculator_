package android.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et_1 = findViewById<EditText>(R.id.et_1)
        val et_2 = findViewById<EditText>(R.id.et_2)
        val tv_result = findViewById<TextView>(R.id.tv_result)
        val btn_plus = findViewById<Button>(R.id.btn_plus)
        val btn_minus = findViewById<Button>(R.id.btn_minus)
        val btn_multiply = findViewById<Button>(R.id.btn_multiply)
        val btn_division = findViewById<Button>(R.id.btn_division)



        btn_plus.setOnClickListener {
            val s_1 = et_1.text.toString().toDouble()
            val s_2 = et_2.text.toString().toDouble()
            val result = s_1 + s_2
            tv_result.text = "$s_1 + $s_2 = $result"
        }

        btn_minus.setOnClickListener {
            val s_1 = et_1.text.toString().toDouble()
            val s_2 = et_2.text.toString().toDouble()
            val result = s_1 - s_2
            tv_result.text = "$s_1 - $s_2 = $result"
        }

        btn_multiply.setOnClickListener {
            val s_1 = et_1.text.toString().toDouble()
            val s_2 = et_2.text.toString().toDouble()
            val result = s_1 * s_2
            tv_result.text = "$s_1 * $s_2 = $result"
        }

        btn_division.setOnClickListener {
            val s_1 = et_1.text.toString().toDouble()
            val s_2 = et_2.text.toString().toDouble()
            val result = s_1 / s_2
            tv_result.text = "$s_1 / $s_2 = $result"
            if (et_1.text.toString().toInt() == 0 || et_2.text.toString().toInt() == 0){
                tv_result.text = "На ноль делить нельзя!"
            }
        }

    }
}