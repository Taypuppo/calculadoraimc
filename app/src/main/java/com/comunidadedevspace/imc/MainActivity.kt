package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar os componentes EditText
        // Criar uma variavel(val) e associar(=) o componente de UI<EditText>
        // Recuperar o botão da tela
        // Colocar ação no botão
        // Recuperar o texto digitado no edtPeso

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        // 1 - Receber dados do usuario como altura e peso
        // 2 - Calcular o IMC
        // IMC = Peso / Altura * Altura
        // 3 - Mostrar o resultado do IMC
        // 4 - Mostrar a classificacao
        // 5 - classificação
        // MENOR QUE 18,5  MAGREZA
        // ENTRE 18,5 E 24,9 NORMAL
        // ENTRE 25,0 E 29,9 SOBREPESO I
        // ENTRE 30,0 E 39,9 OBESIDADE II
        // MAIOR QUE 40,0    OBESIDADE GRAVE

        btnCalcular.setOnClickListener {


            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == "") {

                Snackbar
                    .make(
                        edtPeso,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2

                // Intent - Classe do próprio android

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, resultado)
                startActivity(intent)

            }
        }
    }
}