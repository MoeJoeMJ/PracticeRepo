fun main() {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .forEach { println(it.uppercase()) }
}