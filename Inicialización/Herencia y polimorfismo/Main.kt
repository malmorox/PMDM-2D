import java.util.Scanner

fun main() {
    println("PROGRAMA INTERNO ZOOLÓGICO")

    val animales = mutableListOf<Animal>()
    val sc = Scanner(System.`in`)

    var opcion: Int
    do {
        println(imprimirOpciones())
        opcion = sc.nextInt()
        sc.nextLine()

        when (opcion) {
            1 -> {
                println(elegirAnimal())
                val tipoAnimal = sc.nextInt()
                sc.nextLine()

                val caracteristicas = preguntarCaracteristicasAnimal()
                val nombre = caracteristicas[0]
                val numeroPatas = caracteristicas[1].toInt()
                val peso = caracteristicas[2].toDouble()

                when (tipoAnimal) {
                    1 -> {
                        println(elegirTipoOso())
                        val tipoOsoSc = sc.nextInt()
                        sc.nextLine()

                        val tipoOso = when (tipoOsoSc) {
                            1 -> TipoOso.PARDO
                            2 -> TipoOso.PANDA
                            3 -> TipoOso.POLAR
                            else -> {
                                println("Tipo no válido. Se asignará 'Pardo' por defecto.")
                                TipoOso.PARDO
                            }
                        }

                        val oso = Oso(nombre, numeroPatas, peso, tipoOso)
                        animales.add(oso)
                        println("Oso añadido al zoológico.")
                    }
                    2 -> {
                        println("Introduzca la raza del tigre:")
                        val raza = sc.nextLine()

                        val tigre = Tigre(nombre, numeroPatas, peso, raza)
                        animales.add(tigre)
                        println("Tigre añadido al zoológico.")
                    }
                    3 -> {
                        println("Introduzca el tamaño de los colmillos (cm):")
                        val tamanoColmillos = sc.nextDouble()
                        sc.nextLine()

                        val elefante = Elefante(nombre, numeroPatas, peso, tamanoColmillos)
                        animales.add(elefante)
                        println("Elefante añadido al zoológico.")
                    }
                    else -> println("Tipo de animal no válido.")
                }
            }
            2 -> {
                if (animales.isEmpty()) {
                    println("No hay animales para eliminar.")
                } else {
                    println("Introduzca el índice del animal a eliminar:")
                    val indiceEliminar = sc.nextInt()
                    sc.nextLine()

                    if (indiceEliminar < 1 || indiceEliminar > animales.size) {
                        println("Índice no válido.")
                    } else {
                        animales.removeAt(indiceEliminar - 1)
                        println("Animal eliminado del zoológico.")
                    }
                }
            }
            3 -> println(listarAnimales(animales))
            4 -> println("Saliendo del programa.")
            else -> println("Opción no válida.")
        }

    } while (opcion != 4)
    sc.close()
}

fun imprimirOpciones(): String =
    """
    Elija una opción:
    1. Añadir animal
    2. Eliminar animal
    3. Listar animales
    4. Salir
    """.trimIndent()

fun elegirAnimal(): String =
    """
    ¿Qué animal desea añadir? 
    1. Oso
    2. Tigre
    3. Elefante
    """.trimIndent()

fun elegirTipoOso(): String =
    """
    ¿Qué tipo de oso desea añadir? 
    1. Pardo
    2. Panda
    3. Polar
    """.trimIndent()

fun preguntarCaracteristicasAnimal(): Array<String> {
    val sc = Scanner(System.`in`)

    println("Introduzca el nombre del animal:")
    val nombre = sc.nextLine()

    println("Introduzca el número de patas del animal:")
    val numeroPatas = sc.nextInt()
    sc.nextLine()

    println("Introduzca el peso del animal (kg):")
    val peso = sc.nextDouble()
    sc.nextLine()

    return arrayOf(nombre, numeroPatas.toString(), peso.toString())
}

fun listarAnimales(animales: List<Animal>): String {
    if (animales.isEmpty()) {
        return "No hay animales en el zoológico."
    }

    val listado = StringBuilder("LISTADO DE ANIMALES:\n")
    animales.forEachIndexed { index, animal ->
        val tipoAnimalStr = when (animal) {
            is Oso -> "OSO"
            is Tigre -> "TIGRE"
            is Elefante -> "ELEFANTE"
            else -> "ANIMAL"
        }
        listado.append("${index + 1}. [$tipoAnimalStr] $animal\n")
    }
    return listado.toString()
}