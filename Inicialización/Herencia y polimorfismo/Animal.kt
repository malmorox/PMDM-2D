open class Animal(
    val nombre: String,
    val numeroPatas: Int,
    val peso: Double
) {
    override fun toString(): String {
        return "Nombre: $nombre | Número de patas: $numeroPatas | Peso: $peso kg"
    }
}