package com.victor.correa.calcularnotas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    private lateinit var progress : ProgressBar
    private lateinit var nombreUsuario : EditText
    private lateinit var porcentaje : EditText
    private lateinit var notas : EditText
    private lateinit var finalizar : Button
    private lateinit var enviar : Button

    private var porcentajeAcumulado = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main )


        progress = findViewById(R.id.progress)
        nombreUsuario = findViewById(R.id.nombreUsuario)
        porcentaje = findViewById(R.id.porcentaje)
        notas = findViewById(R.id.notas)
        finalizar = findViewById(R.id.finalizar)
        enviar = findViewById(R.id.enviar)

    }
    fun validarPorcentaje (porcentaje : Int ){

    }


}