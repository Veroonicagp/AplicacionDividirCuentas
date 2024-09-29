package com.example.divisordecuentas

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
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
        button.setOnClickListener{
            //.getText().toString();
            val cuenta = findViewById<TextInputEditText>(R.id.numCuenta).text.toString()
            val Nperso = findViewById<TextInputEditText>(R.id.numPersonas).text.toString()
            Snackbar.make(button, "hola $cuenta , $Nperso", Snackbar.LENGTH_LONG).show()
        }
    }
}