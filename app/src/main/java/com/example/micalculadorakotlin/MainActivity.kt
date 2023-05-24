package com.example.micalculadorakotlin

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnIng: Button
    private lateinit var btnCerrar: Button
    private lateinit var txtUser: EditText
    private lateinit var txtPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarComponentes()
        btnIng.setOnClickListener { ingresar() }
        btnCerrar.setOnClickListener { mostrarDialogoCerrar() }
    }

    private fun iniciarComponentes() {
        btnIng = findViewById(R.id.btnIng)
        btnCerrar = findViewById(R.id.btnCerrar)
        txtPass = findViewById(R.id.txtPass)
        txtUser = findViewById(R.id.txtUser)
    }

    private fun ingresar() {
        val strUsuario: String = resources.getString(R.string.user)
        val strContra: String = resources.getString(R.string.password)

        if (txtUser.text.toString() == strUsuario && txtPass.text.toString() == strContra) {
            val bundle = Bundle()
            bundle.putString("usuario", strUsuario)

            val intent = Intent(this@MainActivity, CalculadorActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

        } else {
            Toast.makeText(this, "Usuario o Contraseña no válidos", Toast.LENGTH_LONG).show()
        }


    }



    private fun mostrarDialogoCerrar() {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Cerrar aplicación")
        builder.setMessage("¿Estás seguro de que quieres cerrar la aplicación?")

        builder.setPositiveButton("Sí") { dialog, _ ->
            cerrarApp() // Cerrar la actividad actual y salir de la aplicación
        }

        builder.setNegativeButton("No", null) // No hacer nada si se selecciona "No"

        val dialog = builder.create()
        dialog.show()
    }

    private fun cerrarApp() {
        finish() // Cerrar la actividad actual y salir de la aplicación
    }
}