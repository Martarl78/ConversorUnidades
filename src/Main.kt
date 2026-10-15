
// Fases 3-7: Conversor de divisas, distancias y temperaturas

// Factores de conversión fijos (val / const val)
const val DOLAR = 1.08
const val LIBRA = 0.86
const val YEN = 163.0
const val FRANCO_SUIZO = 0.95

const val KM_A_METROS = 1000.0
const val KM_A_MILLAS = 0.621371
const val MILLAS_A_KM = 1.609344
const val CM_A_METROS = 0.01

const val CERO_ABSOLUTO_CELSIUS = -273.15
const val CERO_ABSOLUTO_FAHRENHEIT = -459.67

// Funciones de lectura con validación

fun leerNumero(mensaje: String): Double? {
    print(mensaje)
    val numero = readLine()?.trim()?.replace(',', '.')?.toDoubleOrNull()
    if (numero == null) {
        println("Error: entrada no válida, debes introducir un número.")
    }
    return numero
}

fun leerOpcion(mensaje: String): Int? {
    print(mensaje)
    val opcion = readLine()?.trim()?.toIntOrNull()
    if (opcion == null) {
        println("Error: opción no válida.")
    }
    return opcion
}

fun formato(valor: Double): String = "%.2f".format(valor)

// Fase 3: Divisas

fun conversorDivisas() {
    println("\n--- CONVERSOR DE DIVISAS (desde euros) ---")
    println("1. Euros a dólares")
    println("2. Euros a libras esterlinas")
    println("3. Euros a yenes")
    println("4. Euros a francos suizos")

    val opcion = leerOpcion("Elige una opción: ") ?: return
    if (opcion !in 1..4) {
        println("Error: opción no válida.")
        return
    }

    val euros = leerNumero("Cantidad en euros: ") ?: return
    if (euros < 0) {
        println("Error: la cantidad no puede ser negativa.")
        return
    }

    when (opcion) {
        1 -> println("${formato(euros)} euros equivalen a ${formato(euros * DOLAR)} dólares.")
        2 -> println("${formato(euros)} euros equivalen a ${formato(euros * LIBRA)} libras esterlinas.")
        3 -> println("${formato(euros)} euros equivalen a ${formato(euros * YEN)} yenes.")
        4 -> println("${formato(euros)} euros equivalen a ${formato(euros * FRANCO_SUIZO)} francos suizos.")
    }
}

// Fase 4: Distancias

fun conversorDistancias() {
    println("\n--- CONVERSOR DE DISTANCIAS ---")
    println("1. Kilómetros a metros")
    println("2. Metros a kilómetros")
    println("3. Kilómetros a millas")
    println("4. Millas a kilómetros")
    println("5. Centímetros a metros")

    val opcion = leerOpcion("Elige una opción: ") ?: return
    if (opcion !in 1..5) {
        println("Error: opción no válida.")
        return
    }

    val cantidad = leerNumero("Introduce la distancia: ") ?: return
    if (cantidad < 0) {
        println("Error: la cantidad no puede ser negativa.")
        return
    }

    when (opcion) {
        1 -> println("$cantidad kilómetros equivalen a ${cantidad * KM_A_METROS} metros.")
        2 -> println("$cantidad metros equivalen a ${cantidad / KM_A_METROS} kilómetros.")
        3 -> println("$cantidad kilómetros equivalen a ${cantidad * KM_A_MILLAS} millas.")
        4 -> println("$cantidad millas equivalen a ${cantidad * MILLAS_A_KM} kilómetros.")
        5 -> println("$cantidad centímetros equivalen a ${cantidad * CM_A_METROS} metros.")
    }
}

// Fase 5: Temperaturas

fun conversorTemperaturas() {
    println("\n--- CONVERSOR DE TEMPERATURAS ---")
    println("1. Celsius a Fahrenheit")
    println("2. Fahrenheit a Celsius")
    println("3. Celsius a Kelvin")
    println("4. Kelvin a Celsius")

    val opcion = leerOpcion("Elige una opción: ") ?: return
    if (opcion !in 1..4) {
        println("Error: opción no válida.")
        return
    }

    val temperatura = leerNumero("Introduce la temperatura: ") ?: return

    when (opcion) {
        1 -> {
            if (temperatura < CERO_ABSOLUTO_CELSIUS) {
                println("Error: la temperatura no puede ser inferior al cero absoluto (-273.15 °C).")
            } else {
                val f = temperatura * 9 / 5 + 32
                println("$temperatura °C equivalen a ${formato(f)} °F.")
            }
        }
        2 -> {
            if (temperatura < CERO_ABSOLUTO_FAHRENHEIT) {
                println("Error: la temperatura no puede ser inferior al cero absoluto (-459.67 °F).")
            } else {
                val c = (temperatura - 32) * 5 / 9
                println("$temperatura °F equivalen a ${formato(c)} °C.")
            }
        }
        3 -> {
            if (temperatura < CERO_ABSOLUTO_CELSIUS) {
                println("Error: la temperatura no puede ser inferior al cero absoluto (-273.15 °C).")
            } else {
                val k = temperatura + 273.15
                println("$temperatura °C equivalen a ${formato(k)} K.")
            }
        }
        4 -> {
            if (temperatura < 0) {
                println("Error: la temperatura en Kelvin no puede ser inferior a 0.")
            } else {
                val c = temperatura - 273.15
                println("$temperatura K equivalen a ${formato(c)} °C.")
            }
        }
    }
}

// Fase 6: Menú principal con bucle

fun main() {
    var opcion: Int

    do {
        println("\n===== CONVERSOR UNIVERSAL =====")
        println("1. Conversor de divisas")
        println("2. Conversor de distancias")
        println("3. Conversor de temperaturas")
        println("0. Salir")
        print("Elige una opción: ")

        // Si la entrada no es un número, se asigna -1 para caer en "opción no válida"
        opcion = readLine()?.trim()?.toIntOrNull() ?: -1

        when (opcion) {
            1 -> conversorDivisas()
            2 -> conversorDistancias()
            3 -> conversorTemperaturas()
            0 -> println("Gracias, ¡Hasta pronto!")
            else -> println("Error: opción no válida.")
        }
    } while (opcion != 0)
}