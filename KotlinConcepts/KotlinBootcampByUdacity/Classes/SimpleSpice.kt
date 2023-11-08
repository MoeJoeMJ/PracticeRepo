package Classes

class SimpleSpice {
    val name = "curry"
    val spiciness = "mild"
    val heat: Int
        get() {return 5 }
}

fun main() {
    val simpleSpice = SimpleSpice()
    println("${simpleSpice.name} ${simpleSpice.heat}")
}