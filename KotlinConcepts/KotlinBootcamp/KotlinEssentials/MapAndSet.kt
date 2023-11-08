package KotlinEssentials

fun main() {
    val allBooks = setOf("Head First Java", "Effective Java", "Java For Dummies")
    val library = mapOf("Java" to allBooks)
    println(library.any { it.value.contains("Effective Java") })
    val moreBooks = mutableMapOf<String, String>("Kotlin" to "Head First Kotlin")
    moreBooks.getOrPut("Android Development: Big Ranch Guide") { "Android Development" }
    moreBooks.getOrPut("Head First Java") { "Java" }
    println(moreBooks)
}
