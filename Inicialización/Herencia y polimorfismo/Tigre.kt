class Tigre(
    nombre: String,
    numeroPatas: Int,
    peso: Double,
    private val raza: String
) : Animal(nombre, numeroPatas, peso) {

    fun getRaza(): String = raza

    override fun toString(): String {
        return super.toString() + " | Raza: $raza"
    }
}