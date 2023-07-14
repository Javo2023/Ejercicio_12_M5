package com.example.ejercicio_12_m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
fun main(){
    var usuarios = mutableListOf<Usuario>()
    println("ingresar cantidad de usuarios")
    val cantidadUsuarios = readln().toInt()
    for(i in 1..cantidadUsuarios){
        println("Ingrese nombre")
        var nombre = readln()
        while (!validarNombre(nombre)) {
            println("nombre inválido, ingrese un nombre válido")
            nombre = readln()
        }
        var apellido = readln()
        validarApellido(apellido)

        var edad = readln().toInt()
        var correo = readln()
        var sistemaSalud = readln()
        var usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)


    }
    for(u in usuarios){
        println(u)

    }

}

fun validarApellido(apellido: String) : Boolean {
    return apellido.length in 1..20
}

fun validarNombre(nombre: String) : Boolean {
    return nombre.length in 1..20
}

data class Usuario(var nombre: String, var apellido:String, var edad: Int, var correo: String, var sistemaSalud:String){

}