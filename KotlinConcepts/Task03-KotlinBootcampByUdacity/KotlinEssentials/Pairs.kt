package KotlinEssentials

class Book(val title: String,val author: String, val year: Int) {
    fun getPair(): Pair<String, String> {
        val pair = title to author
        return pair
    }
    fun getTriple(): Triple<String,String,Int> {
        val triple = Triple(title,author,year)
        return triple
    }
}

fun main() {
    val book = Book("Harry Potter","JK Rowling",2003)
    val (title,author) = book.getPair()
    println("Here is your book $title written by $author.")
    val (title1, author1, year1) = book.getTriple()
    println("Here is your book $title1 written by $author1 in $year1.")
}