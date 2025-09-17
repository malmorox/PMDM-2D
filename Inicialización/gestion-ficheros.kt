import java.io.File
import java.io.IOException

fun main() {
    val ruta = "prueba.txt"
    var archivo = File(ruta)
    var texto = "hola\nq tal\nestas"

    try {
        val bw = archivo.bufferedWriter()
        bw.write(texto)
        bw.close()
        println("Archivo creado con exito")

        val br = archivo.bufferedReader().use { it.readText() }
        println(br)
        archivo.bufferedWriter().close()
    } catch (e: IOException) {
        println("Error al cargar el archivo: ${e.message}")
    }
}
