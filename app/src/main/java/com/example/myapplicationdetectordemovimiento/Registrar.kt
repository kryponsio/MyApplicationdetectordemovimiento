package com.example.myapplicationdetectordemovimiento

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Registrar : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        emailEditText = findViewById(R.id.Correo)
        passwordEditText = findViewById(R.id.clave_alarma)

        findViewById<Button>(R.id.boton2).setOnClickListener {

            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa correo y clave", Toast.LENGTH_SHORT).show()
            } else {
                try {
                    val sharedPreferences = getSharedPreferences("AlarmSystem", MODE_PRIVATE)
                    with(sharedPreferences.edit()) {
                        putString("email", email)
                        putString("password", password)
                        apply()
                    }
                    Toast.makeText(this, "Credenciales guardadas", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, interfazAlarma::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(this, "Error al guardar credenciales: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
