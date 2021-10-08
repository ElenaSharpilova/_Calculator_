package android.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var getResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        getResult = findViewById(R.id.tv_result)

        val result = intent.getStringExtra("result")
        getResult.text = result

    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        getResult.text = ""
//    }
}