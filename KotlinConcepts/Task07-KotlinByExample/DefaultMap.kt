fun main() {
    val map = mapOf(1 to "One", 2 to "Two", 3 to "Three").withDefault { key -> "Unknown number" }
    println(map.getValue(1))
    println(map.getValue(4))
}