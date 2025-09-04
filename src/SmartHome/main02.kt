package SmartHome


// --- Función Principal para probar todo ---
fun main() {
    // Creamos los dispositivos individuales
    val smartTv = SmartTvDevice("Android TV", "Entertainment")
    val smartLight = SmartLightDevice("Google Light", "Utility")

    // Creamos la casa inteligente con esos dispositivos
    val myHome = SmartHome(smartTv, smartLight)

    // 1. Intentamos usar los dispositivos mientras están apagados
    println("\n--- Intentando usar dispositivos apagados ---")
    smartTv.decreaseVolume()
    smartLight.decreaseBrightness()

    // 2. Encendemos los dispositivos a través de SmartHome
    println("\n--- Encendiendo dispositivos ---")
    myHome.turnOnTv()
    myHome.turnOnLight()
    println("Total devices turned on: ${myHome.deviceTurnOnCount}")

    // 3. Usamos los dispositivos ahora que están encendidos
    println("\n--- Usando dispositivos encendidos ---")
    smartTv.decreaseVolume()
    smartLight.decreaseBrightness()

    // 4. Apagamos un dispositivo
    println("\n--- Apagando un dispositivo ---")
    myHome.turnOffTv()
    println("Total devices turned on: ${myHome.deviceTurnOnCount}")

    // 5. Imprimimos la información de un dispositivo
    println("\n--- Mostrando información ---")
    smartTv.printDeviceInfo()
}