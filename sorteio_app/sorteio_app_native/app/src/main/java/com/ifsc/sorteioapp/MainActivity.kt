package com.ifsc.sorteioapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var minEditText: EditText;
    lateinit var maxEditText: EditText;
    lateinit var resultText: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        minEditText = findViewById<EditText>(R.id.minValueEditText);
        maxEditText = findViewById<EditText>(R.id.maxValueEditText);
        resultText = findViewById<TextView>(R.id.resultado);
    }

    fun sortear(buttonView: View) {
        var min = getIntValueFromEditText(minEditText);
        var max = getIntValueFromEditText(maxEditText);

        if (min == null || max == null)
            return;

        var result = Random.nextInt(min, max + 1);
        resultText.setText(result.toString());
    }

    private fun getIntValueFromEditText(editText: EditText): Int? {
        var text = editText.text.toString();

        if (text.isEmpty()) {
            resultText.setText("Informe um valor!");
            return null;
        }

        return text.toInt();
    }
}