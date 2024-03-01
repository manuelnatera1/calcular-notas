package com.victor.correa.calcularnotas

class Estudiante(){
    var nombre : String = ""
    var notas : List<Double> = listOf()
    var porcentaje : List<Int> = listOf()

    fun calcularPromedio(): Double{
        var sumaNotas = 0.0
        for(n in notas){
            sumaNotas += n
        }
        return sumaNotas / notas.size
    }
    fun notaFinal(): Double {
        var notaFinal: Double = 0.0
        var contador = 0
        for (n in notas) {
            notaFinal += (n * porcentaje[contador]) / 100
            contador++
        }
        return notaFinal
    }

}