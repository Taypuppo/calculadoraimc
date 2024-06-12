package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        val classificacao: String
        val colorResId: Int

        when {
            result <= 18.5f -> {
                classificacao = "MAGREZA"
                colorResId = R.color.magreza
            }
            result > 18.5f && result <= 24.9f -> {
                classificacao = "NORMAL"
                colorResId = R.color.normal
            }
            result > 25f && result <= 29.9f -> {
                classificacao = "SOBREPESO"
                colorResId = R.color.sobrepeso
            }
            result > 30f && result <= 39.9f -> {
                classificacao = "OBESIDADE"
                colorResId = R.color.obesidade
            }
            else -> {
                classificacao = "OBESIDADE GRAVE"
                colorResId = R.color.obesidade_grave
            }
        }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(ContextCompat.getColor(this, colorResId))
    }
}
