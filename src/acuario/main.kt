package acuario

fun construirAcuario() {
    val acuario1 = Acuario()
    acuario1.imprimirTamano()

    val acuario2 = Acuario(ancho = 25)
    acuario2.imprimirTamano()

    val acuario3 = Acuario(alto = 35, largo = 110)
    acuario3.imprimirTamano()

    val acuario4 = Acuario(ancho = 25, alto = 35, largo = 110)
    acuario4.imprimirTamano()

    val acuario6 = Acuario(numeroDePeces = 29)
    acuario6.imprimirTamano()

    val acuario7  = Acuario(numeroDePeces = 29)
    acuario7.imprimirTamano()
    acuario7.volumen = 70
    acuario7.imprimirTamano()

    val miTorre = TanqueTorre(diametro = 25, alto = 40)
    miTorre.imprimirTamano()
}

fun crearPeces() {
    val tiburon = Tiburon()
    val pezPayaso = PezPayaso()

    println("\n----- Creando Peces -----")

    // Pez 1: Tiburón
    print("El tiburón es de color ${tiburon.color} y se alimenta de: ")
    tiburon.comer()

    // Pez 2: Pez Payaso
    print("El pez payaso es de color ${pezPayaso.color} y se alimenta de: ")
    pezPayaso.comer()
}

fun main() {
    println("----- Construyendo Acuarios -----")
    construirAcuario()
    crearPeces()
}