package com.example.divisordecuentas

import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(R.id.bttnCalcular)
        val mySwitch = findViewById<SwitchMaterial>(R.id.swPropina)

        mySwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            val numCuenta = findViewById<TextInputEditText>(R.id.numCuenta).text.toString()
            val numC = numCuenta.toDoubleOrNull()
            val numPerso = findViewById<TextInputEditText>(R.id.numPersonas).text.toString()
            val numP = numPerso.toDoubleOrNull()
            var cntTotal = findViewById<TextView>(R.id.cntTotal).text.toString()
            var cntPersona = findViewById<TextView>(R.id.cntPersona).text.toString()
            var slider = findViewById<Slider>(R.id.cntPersona).value
            val total = numC!!.div(numP!!)
            val propina = total.div(slider)
            if (isChecked) {
                button.setOnClickListener {
                    Snackbar.make(button, "hola $numCuenta", Snackbar.LENGTH_LONG).show()
                    val totalPropina = total + propina
                    val totalPropinaPers = totalPropina.div(numPerso.toDouble())
                    cntTotal = ("Total persona = $totalPropina")
                    cntPersona = ("Total persona = $totalPropinaPers")
                }// Acciones al estar activo
            } else {
                cntTotal = ("Total persona = $numCuenta")
                cntPersona = ("Total persona = $total")

            }

        }
        }
    }
