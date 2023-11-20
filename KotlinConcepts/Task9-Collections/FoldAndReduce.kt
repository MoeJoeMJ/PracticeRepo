fun main() {
    val numbers = listOf(5, 2, 10, 4)
    numbers.getOrNull(3)
    val reduceList = numbers.reduce { sum, element -> sum + element * 2} // Uses first and second elements as arguments
    println(reduceList)
    val foldList = numbers.fold(0) { sum, element -> sum + element * 2} // takes an initial value and uses it
    println(foldList)
}

/*
Output:
    37
    42
*/
