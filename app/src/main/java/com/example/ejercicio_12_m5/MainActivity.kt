package com.example.ejercicio_12_m5
import java.util.regex.Pattern
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
fun main(){
    val usuarios = mutableListOf<Usuario>()
    println("ingresar cantidad de usuarios")
    val cantidadUsuarios = readln().toInt()
    for(i in 1..cantidadUsuarios){
        println("Ingrese nombre usuario "+i)
        var nombre = readln()
        while (!validarNombre(nombre)) {
            println("nombre inválido, ingrese un nombre válido")
            nombre = readln()
        }
        println("Ingrese Apellido usuario "+i)
        var apellido = readln()

        while (!validarApellido(apellido)) {
            println("Apellido inválido, Ingrese un apellido válido.")
            apellido = readln()
        }

        println("Ingrese edad usuario "+i)
        var edad = readln()
        while (!validarEdad(edad)) {
            println("La edad es inválida, ingrese solo números")
            edad = readln()
        }


        println("Ingrese correo usuario " + i)
        var correo = readln()
        while (!validarCorreo(correo)){
            println("Correo inválido, ingrese correo válido")
            correo = readln()

        }
               
        println("Ingrese Sistema de Salud usuario" + i)

        println("1. Fonasa")
        println("2. Isapre")
        println("3. Particular")
        var sistemaSalud = readLine()?.toIntOrNull()

        when (sistemaSalud) {
            1 -> {
                println("Has seleccionado FONASA")
            }

            2 -> {
                println("Has seleccionado Isapre")
            }

            3 -> {
                println("Has seleccionado Particular")
            }

            else -> {
                println("ingrese una opción válida")
                sistemaSalud = readLine()?.toIntOrNull()
            }

        }
        var usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)


    }
    for(u in usuarios.sortedBy {
        usuario -> usuario.edad
    }){
        println("$u")

    }

}


fun validarCorreo(correo: String): Boolean {
    val patron = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")

    return patron.matches(correo)
}

fun validarEdad(edad: String):Boolean {

    return edad.matches(Regex("\\d+"))
}

private fun Int.matches(regex: Regex) {

}

fun validarApellido(apellido: String) : Boolean {
    val patron = Pattern.compile("^[a-zA-Z]+$")
    return patron.matcher(apellido).matches()
}



fun validarNombre(nombre: String) : Boolean {
    return nombre.length in 1..20
}

data class Usuario(var nombre: String, var apellido:String, var edad: String, var correo: String, var sistemaSalud: Int?){

}