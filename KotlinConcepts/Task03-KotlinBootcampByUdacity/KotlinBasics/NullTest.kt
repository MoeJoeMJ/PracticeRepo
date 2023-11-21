package KotlinBasics

fun main() {
    val nullTest: Int? = null
    println(nullTest?.plus(1) ?: 0)
}
