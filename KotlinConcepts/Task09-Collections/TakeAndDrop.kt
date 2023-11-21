fun main() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.take(3))
    println(numbers.takeLast(3))
    println(numbers.drop(3))
    println(numbers.dropLast(3))
    println()
    println(numbers.takeWhile { it != "four" })
    println(numbers.takeLastWhile { !it.startsWith('t') })
    println(numbers.dropWhile { it.length == 3 })
    println(numbers.dropLastWhile { it.contains('i') })
}

/*
Output:
    [one, two, three]
    [four, five, six]
    [four, five, six]
    [one, two, three]

    [one, two, three]
    [four, five, six]
    [three, four, five, six]
    [one, two, three, four]
*/
