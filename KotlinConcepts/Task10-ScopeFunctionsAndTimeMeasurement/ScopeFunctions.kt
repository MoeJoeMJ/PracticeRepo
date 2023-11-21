data class Person(var name: String, var age: Int = 0)

fun main() {
    val numbers = mutableListOf("one", "two", "three", "four", "five")

    // let
    val letValue = numbers.filter { it.length > 3 }.let { println(it) }
    println()

    //with
    with(numbers) {
        println("The list: $this")
        println("Size of the list: $size")
    }
    println()

    //run
    val runValue = numbers.filter { it.length > 3 }.run { print(size) }
    println()

    // apply
    val john = Person("John").apply { age = 20 }.let(::println)
    println()

    //also
    val alsoValue = numbers.add("six").also { println("New element has been added") }

}