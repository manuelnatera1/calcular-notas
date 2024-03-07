package com.victor.correa.calcularnotas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var progress : ProgressBar
    private lateinit var ingresarNombre : EditText
    private lateinit var ingresarPorcentaje : EditText
    private lateinit var ingresarNotas : EditText
    private lateinit var finalizar : Button
    private lateinit var guardar : Button
    private lateinit var promedio : TextView
    private lateinit var notaFinal : TextView
    private lateinit var nuevoEstudiante : Button
    private var estudianteActual: Estudiante = Estudiante()

    private var porcentajeAcumulado = 0
    val listaNotas : MutableList<Double> = mutableListOf()
    val listaPorcentaje : MutableList<Int> = mutableListOf()
    val listaEstudiantes : MutableList<Estudiante> = mutableListOf()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main )

        progress = findViewById(R.id.progress)
        ingresarNombre = findViewById(R.id.ingresarNombre)
        ingresarPorcentaje = findViewById(R.id.ingresarPorcentaje)
        ingresarNotas = findViewById(R.id.ingresarNotas)
        finalizar = findViewById(R.id.finalizar)
        guardar = findViewById(R.id.guardar)
        promedio = findViewById(R.id.promedio)
        notaFinal = findViewById(R.id.notaFinal)
        nuevoEstudiante = findViewById(R.id.nuevoEstudiante)

        nuevoEstudiante.setOnClickListener{
            nuevoEstudiante()
        }
        finalizar.setOnClickListener{
            promedio.text = "promedio :" + estudianteActual.calcularPromedio()
            notaFinal.text = "nota final :" + estudianteActual.notaFinal()
            nuevoEstudiante.isEnabled = true
        }

        guardar.setOnClickListener {
            val nota = (ingresarNotas.text.toString())
            val porcentaje = (ingresarPorcentaje.text.toString())
            val nombre = (ingresarNombre.text.toString())



            if (validarVacio(nombre, nota, porcentaje)){
                if (validarNombre(nombre) &&
                    validarNota(nota.toDouble()) &&
                    validarPorcentaje((porcentaje.toInt()))
                ){
                    listaNotas.add(nota.toDouble())
                    listaPorcentaje.add(porcentaje.toInt())


                    porcentajeAcumulado += porcentaje.toInt()

                    actualizarProgress(porcentajeAcumulado)

                    ingresarNombre.isEnabled = false
                    ingresarNotas.text.clear()
                    ingresarPorcentaje.text.clear()

                    mostrarMensaje("la nota fue ingresada correctamente")
                }else{
                   mostrarMensaje("verifique los datos ingresados")
                }
             }else{
                 mostrarMensaje("Datos incompletos")
             }
        }
    }
    fun actualizarProgress(porcentaje : Int) {
        progress.progress = porcentaje
        if (porcentaje >= 100){
            finalizar.isEnabled = true
            estudianteActual.nombre = (ingresarNombre.text.toString())
            estudianteActual.porcentaje = listaPorcentaje
            estudianteActual.notas = listaNotas
            listaEstudiantes.add(estudianteActual)
        }
    }
    fun nuevoEstudiante(){
        ingresarNombre.text.clear()
        ingresarPorcentaje.text.clear()
        ingresarNotas.text.clear()
        promedio.text = ""
        notaFinal.text = ""
        progress.progress = 0
        porcentajeAcumulado = 0

    }
    fun mostrarMensaje(mensaje : String){
        Toast.makeText(this,
            mensaje,
        Toast.LENGTH_LONG).show()
    }
    fun validarVacio(nombre: String, nota : String, porcentaje: String): Boolean{
        return !nombre.isNullOrEmpty() && !nota.isNullOrEmpty() && !porcentaje.isNullOrEmpty()
    }
    fun validarNombre(nombre : String): Boolean {
        return !nombre.matches(Regex(".*\\d.*"))

    }
    fun validarNota(nota : Double) : Boolean{
        return nota >= 0 && nota <= 5
    }
    fun validarPorcentaje(porcentaje : Int ) : Boolean{
        return porcentajeAcumulado + porcentaje <=100
    }
}



