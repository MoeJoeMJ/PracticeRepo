class Lesson(val name: String)

data class Book(val lessons: List<Lesson>)

fun main() {
    val book = Book(listOf(Lesson("Moral"), Lesson("Philosophy"), Lesson("Spirituality")))
    println("Lesson names:")
    for (index in 0..<book.lessons.size) {
        println("${book.component1()[index].name}")
        val intlist = listOf(1, 2, 3)
        println(intlist.maxByOrNull { it })
    }
}