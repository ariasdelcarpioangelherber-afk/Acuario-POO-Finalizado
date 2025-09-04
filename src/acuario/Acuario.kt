package acuario
import kotlin.math.PI

open class Acuario (largo: Int = 100, ancho: Int = 20, alto: Int = 40) {
    var largo: Int = largo
    var ancho: Int = ancho
    var alto: Int = alto

    open val forma = "rectángulo"
    open var agua: Double = 0.0
        get() = volumen * 0.9

    open var volumen: Int
        get() = ancho * alto * largo / 1000
        set(valor){
            alto = (valor * 1000) / (ancho * largo)
        }

    init {
        println("inicializando acuario")
    }

    constructor(numeroDePeces: Int) : this() {
        val tanque = numeroDePeces * 2000 * 1.1
        alto = (tanque / (largo * ancho)).toInt()
    }

    fun imprimirTamano() {
        println("----------")
        println(forma)
        println("Ancho: $ancho cm, Largo: $largo cm, Alto: $alto cm")
        println("volumen: $volumen l Agua: $agua l (${agua / volumen * 100.0}% lleno)")
    }
}

class TanqueTorre (alto: Int, var diametro: Int): Acuario(alto = alto, ancho = diametro, largo = diametro) {
    override var volumen: Int
        get() = (ancho.toDouble()/2 * largo.toDouble()/2 * alto.toDouble() / 1000 * PI).toInt()
        set(valor) {
            alto = ((valor.toDouble() * 1000 / PI) / (ancho.toDouble()/2 * largo.toDouble()/2)).toInt()
        }

    override var agua = volumen * 0.8
    override val forma = "cilindro"
}
