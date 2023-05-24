package com.example.micalculadorakotlin

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class CalculadorActivity : AppCompatActivity() {
    private lateinit var btnSuma:Button;
    private lateinit var btnResta:Button;
    private lateinit var btnMulti:Button;
    private lateinit var btnDivi:Button;
    private lateinit var btnLimpiar: Button;
    private lateinit var btnCerrar: Button;

    private lateinit var txtNum1 : EditText;
    private lateinit var txtNum2 : EditText;
    private lateinit var lblRes : TextView;
    private var calculadora = Calculadora(0,0);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculador)
        iniciarComponentes()

        val bundle = intent.extras
        val usuario = bundle?.getString("usuario")

        val txtUsuario = findViewById<TextView>(R.id.txtUsuario)
        txtUsuario.text = "Bienvenido $usuario"

        btnSuma.setOnClickListener{(btnSumar())}
        btnResta.setOnClickListener{btnRestar()}
        btnMulti.setOnClickListener{btnMultiplicar()}
        btnDivi.setOnClickListener{btnDividir()}
        btnLimpiar.setOnClickListener{limpiar()}
        btnCerrar.setOnClickListener{Cerrar()}

    }

    private fun limpiar(){
        txtNum1.setText("");
        txtNum2.setText("");
        lblRes.setText("");
    }

    private fun Cerrar(){
        val confirmar = AlertDialog.Builder(this)
        confirmar.setTitle("Calculadora")
        confirmar.setMessage("¿ Deseas regresar ?")
        confirmar.setPositiveButton("Confirmar"){
                dialogoInterface,which->finish()

        }
        confirmar.setNegativeButton("Cancelar"){
                dialogoInterface,wich->
        }.show()
    }

    private fun iniciarComponentes(){
        btnSuma = findViewById(R.id.btnSuma)
        btnResta = findViewById(R.id.btnResta)
        btnMulti = findViewById(R.id.btnMulti)
        btnDivi = findViewById(R.id.btnDivi)

        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)

        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)

        lblRes = findViewById(R.id.lblRes)
    }

    private fun btnSumar(){
        val number1 = txtNum1.text.toString()
        val number2 = txtNum2.text.toString()

        if (TextUtils.isEmpty(number1) || TextUtils.isEmpty(number2)) {
            Toast.makeText(
                this@CalculadorActivity,
                "Por favor, ingresa ambos números",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // Ambos campos tienen información, realizar la acción
            calculadora.num1 = txtNum1.text.toString().toInt()
            calculadora.num2 = txtNum2.text.toString().toInt()

            // Mostrar el resultado en un TextView o en otro lugar de la interfaz de usuario
            lblRes.text = calculadora.suma().toString()
        }

    }

    private fun btnRestar(){
        val number1 = txtNum1.text.toString()
        val number2 = txtNum2.text.toString()

        if (TextUtils.isEmpty(number1) || TextUtils.isEmpty(number2)) {
            Toast.makeText(
                this@CalculadorActivity,
                "Por favor, ingresa ambos números",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // Ambos campos tienen información, realizar la acción
            calculadora.num1 = txtNum1.text.toString().toInt()
            calculadora.num2 = txtNum2.text.toString().toInt()

            // Mostrar el resultado en un TextView o en otro lugar de la interfaz de usuario
            lblRes.text = calculadora.resta().toString()
        }
    }

    private fun btnMultiplicar(){
        val number1 = txtNum1.text.toString()
        val number2 = txtNum2.text.toString()

        if (TextUtils.isEmpty(number1) || TextUtils.isEmpty(number2)) {
            Toast.makeText(
                this@CalculadorActivity,
                "Por favor, ingresa ambos números",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // Ambos campos tienen información, realizar la acción
            calculadora.num1 = txtNum1.text.toString().toInt()
            calculadora.num2 = txtNum2.text.toString().toInt()

            // Mostrar el resultado en un TextView o en otro lugar de la interfaz de usuario
            lblRes.text = calculadora.multiplicacion().toString()
        }


    }

    private fun btnDividir(){
        val number1 = txtNum1.text.toString()
        val number2 = txtNum2.text.toString()

        if (TextUtils.isEmpty(number1) || TextUtils.isEmpty(number2)) {
            Toast.makeText(
                this@CalculadorActivity,
                "Por favor, ingresa ambos números",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // Ambos campos tienen información, realizar la acción
            calculadora.num1 = txtNum1.text.toString().toInt()
            calculadora.num2 = txtNum2.text.toString().toInt()

            // Mostrar el resultado en un TextView o en otro lugar de la interfaz de usuario
            try {
                lblRes.text = calculadora.division().toString()
                // Hacer algo con el resultado
            } catch (e: ArithmeticException) {
                // Manejar la excepción
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
            }
        }



    }
}
