class Elefante(
    nombre: String,
    numeroPatas: Int,
    peso: Double,
    private val tamanoColmillos: Double
) : Animal(nombre, numeroPatas, peso) {

    fun getTamanoColmillos(): Double = tamanoColmillos

    override fun toString(): String {
        return super.toString() + " | Tamaño de colmillos: %.2f cm".format(tamanoColmillos)
    }
}