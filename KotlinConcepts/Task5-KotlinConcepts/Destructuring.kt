fun main() {
    val map: Map<Int, String> = mapOf(1 to "One", 2 to "Two", 3 to "Three")
    for ((K,V) in map)  {
        println("$K -> $V")
    }
}