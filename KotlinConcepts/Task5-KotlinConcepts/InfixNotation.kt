infix fun Int.isGreaterThan(num: Int): Boolean {
    return this > num
}

fun main() {
    println(7 isGreaterThan 3)
}
