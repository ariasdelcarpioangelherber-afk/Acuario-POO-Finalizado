package acuario

// 1. Interfaz creada con un método comer()
interface AccionPez {
    fun comer()
}

// Clase abstracta Pez (sin cambios)
abstract class Pez {
    abstract val color: String
}

// 2. Clases modificadas para implementar la interfaz AccionPez
class Tiburon : Pez(), AccionPez {
    override val color = "gris"
    override fun comer() {
        println("cazar y comer peces")
    }
}

class PezPayaso : Pez(), AccionPez {
    override val color = "dorado"
    override fun comer() {
        println("comer algas")
    }
}