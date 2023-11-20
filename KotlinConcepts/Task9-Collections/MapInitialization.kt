// Alternative way to initialize map to save memory
fun main() {
    val numbersMap = mutableMapOf<String, String>().apply { this["one"] = "1"; this["two"] = "2" }
    println(numbersMap)
}