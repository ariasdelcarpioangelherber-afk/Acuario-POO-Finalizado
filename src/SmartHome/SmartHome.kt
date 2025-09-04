package smarthome

// --- Clase Base (Sin cambios) ---
open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "off"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

// --- Subclases Específicas (Sin cambios) ---
class SmartTvDevice(name: String, category: String) : SmartDevice(name, category) {

    override val deviceType = "Smart TV"

    private var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    private var channelNumber = 1
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }

    fun decreaseVolume() {
        if (deviceStatus == "on") {
            speakerVolume--
            println("Speaker volume decreased to $speakerVolume.")
        } else {
            println("$name is off. Cannot decrease volume.")
        }
    }

    fun previousChannel() {
        if (deviceStatus == "on") {
            channelNumber--
            println("Channel changed to $channelNumber.")
        } else {
            println("$name is off. Cannot change channel.")
        }
    }
}

class SmartLightDevice(name: String, category: String) : SmartDevice(name, category) {

    override val deviceType = "Smart Light"

    private var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun decreaseBrightness() {
        if (deviceStatus == "on") {
            brightnessLevel--
            println("Brightness decreased to $brightnessLevel.")
        } else {
            println("$name is off. Cannot decrease brightness.")
        }
    }
}

// --- Clase Contenedora MODIFICADA ---
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    var deviceTurnOnCount = 0
        private set

    // --- Métodos de encendido y apagado (sin cambios) ---
    fun turnOnTv() {
        if(smartTvDevice.deviceStatus == "off"){
            deviceTurnOnCount++
            smartTvDevice.turnOn()
            println("${smartTvDevice.name} is now on.")
        }
    }

    fun turnOffTv() {
        if(smartTvDevice.deviceStatus == "on"){
            deviceTurnOnCount--
            smartTvDevice.turnOff()
            println("${smartTvDevice.name} is now off.")
        }
    }

    fun turnOnLight() {
        if(smartLightDevice.deviceStatus == "off"){
            deviceTurnOnCount++
            smartLightDevice.turnOn()
            println("${smartLightDevice.name} is now on.")
        }
    }

    fun turnOffLight() {
        if(smartLightDevice.deviceStatus == "on"){
            deviceTurnOnCount--
            smartLightDevice.turnOff()
            println("${smartLightDevice.name} is now off.")
        }
    }

    // --- NUEVOS MÉTODOS AGREGADOS (Parte final del desafío) ---
    fun decreaseTvVolume() {
        smartTvDevice.decreaseVolume()
    }

    fun changeTvChannelToPrevious() {
        smartTvDevice.previousChannel()
    }

    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

    fun decreaseLightBrightness() {
        smartLightDevice.decreaseBrightness()
    }
}
