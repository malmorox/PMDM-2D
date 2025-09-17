class Oso(
    nombre: String,
    numeroPatas: Int,
    peso: Double,
    private val tipoOso: TipoOso
) : Animal(nombre, numeroPatas, peso) {

    fun getTipoOso(): String = when (tipoOso) {
        TipoOso.POLAR -> "Polar"
        TipoOso.PANDA -> "Panda"
        TipoOso.PARDO -> "Pardo"
    }

    override fun toString(): String {
        return super.toString() + " | Tipo de oso: ${getTipoOso()}"
    }
}