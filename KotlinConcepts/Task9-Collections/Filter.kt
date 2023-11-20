fun main() {
    val numbers = listOf("one", "two", "three", "four")

    val filteredIndex = numbers.filterIndexed { index, value -> index != 0 && value.length > 3}
    println("filterIndexed list: $filteredIndex")  //  takes a predicate with two arguments: the index and the value of an element.

    val filteredNot = numbers.filterNot { it.length > 3 }
    println("filteredNot list: $filteredNot")  // filters by negative condition

    println(numbers.any())  // returns true if the list is not empty
}