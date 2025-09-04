package smarthome


import smarthome.*


fun main() {
    // 1. Creamos los dispositivos y la casa
    val smartTv = SmartTvDevice("Android TV", "Entertainment")
    val smartLight = SmartLightDevice("Google Light", "Utility")
    val myHome = SmartHome(smartTv, smartLight)

    // 2. Encendemos los dispositivos a través de la casa
    println("--- Encendiendo dispositivos ---")
    myHome.turnOnTv()
    myHome.turnOnLight()
    println("Total devices turned on: ${myHome.deviceTurnOnCount}")

    // 3. Usamos los métodos del "control remoto" de SmartHome
    println("\n--- Usando los métodos de SmartHome ---")
    myHome.decreaseTvVolume()
    myHome.changeTvChannelToPrevious()
    myHome.decreaseLightBrightness()

    // 4. Mostramos la información a través de la casa
    println("\n--- Mostrando información desde SmartHome ---")
    myHome.printSmartTvInfo()
    myHome.printSmartLightInfo()

    // 5. Apagamos un dispositivo para ver el contador
    println("\n--- Apagando TV ---")
    myHome.turnOffTv()
    println("Total devices turned on: ${myHome.deviceTurnOnCount}")
}