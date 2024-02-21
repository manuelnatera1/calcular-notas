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
    private lateinit var ingresarPorcentaje : EditText
    private lateinit var ingresarNotas : EditText
    private lateinit var finalizar : Button
    private lateinit var guardar : Button

    private var porcentajeAcumulado = 0
    val listaNotas : MutableList<Double> = mutableListOf()
    val listaPorcentaje : MutableList<Int> = mutableListOf()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main )


        progress = findViewById(R.id.progress)
        nombreUsuario = findViewById(R.id.ingresarNombre)
        ingresarPorcentaje = findViewById(R.id.ingresarPorcentaje)
        ingresarNotas = findViewById(R.id.ingresarNotas)
        finalizar = findViewById(R.id.finalizar)
        guardar = findViewById(R.id.guardar)

        guardar.setOnClickListener {

            val nota = (ingresarNotas.text.toString()).toDouble()
            val porcentaje = (ingresarPorcentaje.text.toString()).toInt()
            if (validarNota(nota) && validarPorcentaje(porcentaje)){
                listaNotas.add(nota)
                listaPorcentaje.add(porcentaje)
                porcentajeAcumulado += porcentaje

                ingresarNotas.text.clear()
                ingresarPorcentaje.text.clear()

            }else{
                //TODO informar al usuario que la nota ingresada no es valida
            }
        }
    }
    fun actualizarProgreso(porcentaje : Int) {
        progress.progress = porcentaje
    }
    fun validarNota(nota : Double) : Boolean{
        return nota >= 0 && nota <= 5
    }
    fun validarPorcentaje(porcentaje : Int ) : Boolean{
        return porcentajeAcumulado + porcentaje <=100
    }

}