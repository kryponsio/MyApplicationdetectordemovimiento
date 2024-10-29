package com.example.myapplicationdetectordemovimiento

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class interfazAlarma : AppCompatActivity() {

    private lateinit var password: String
    private var isAlarmActive: Boolean = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_interfaz_alarma)

        // Recuperar la contraseña guardada
        val sharedPreferences = getSharedPreferences("AlarmSystem", MODE_PRIVATE)
        password = sharedPreferences.getString("password", "") ?: ""

        findViewById<Button>(R.id.Activar).setOnClickListener {
            activateAlarm()
        }
        findViewById<Button>(R.id.Desactivar).setOnClickListener {
            deactivateAlarm()
        }
        findViewById<Button>(R.id.Activar2).setOnClickListener {
            activateAlarm()
        }
        findViewById<Button>(R.id.Desactivar2).setOnClickListener {
            deactivateAlarm()
        }
        findViewById<Button>(R.id.Activar3).setOnClickListener {
            activateAlarm()
        }
        findViewById<Button>(R.id.Desactivar3).setOnClickListener {
            deactivateAlarm()
        }
        findViewById<Button>(R.id.inicio).setOnClickListener {
            val intent = Intent(this, interfazAlarma::class.java)
            startActivity(intent)
        }

        // Manejo de insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main4)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun activateAlarm() {
        try {
            if (!isAlarmActive) {
                isAlarmActive = true
                // Aquí puedes implementar la lógica real para activar la alarma
                Toast.makeText(this, "Alarma activada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "La alarma ya está activa", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error al activar la alarma: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deactivateAlarm() {
        try {
            if (isAlarmActive) {
                isAlarmActive = false
                // Aquí puedes implementar la lógica real para desactivar la alarma
                Toast.makeText(this, "Alarma desactivada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "La alarma ya está desactivada", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error al desactivar la alarma: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}

