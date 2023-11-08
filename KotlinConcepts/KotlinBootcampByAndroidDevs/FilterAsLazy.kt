fun main() {
    val singers = listOf("Elton","Prince","Elvis")
    val filteredByEager = singers.filter { it.startsWith("E") }  // filters are eager by default
    println("Prints the list: $filteredByEager")

    val filteredByLazy = singers.asSequence().filter { it[0] == 'E' }  // used asSequence to make it lazy
    println("Prints the reference: $filteredByLazy")
    println("Now it prints the list: ${filteredByLazy.toList()}")
}