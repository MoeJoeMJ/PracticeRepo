package KotlinBasics

fun main() {
    val fishName = "Salmon"
    when(fishName.length){
        0 -> println("Fish name is empty")
        in 3..12 -> println("Good fish name")
        else -> println("OK fish name")
    }
}