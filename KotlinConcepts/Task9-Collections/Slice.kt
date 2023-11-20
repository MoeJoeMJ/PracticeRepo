fun main() {
    val numbers = listOf("zero", "one", "two", "three", "four", "five", "six")
    println(numbers.slice(0..3))
    println(numbers.slice(0..6 step 2))
    println(numbers.slice(setOf(0, 1, 2)))
}