package Classes

open class Book(val title: String = "unknown", val author: String = "unknown") {
    private var currentPage = 1
    open val readPage:() -> Int = {++currentPage}

}

class eBook(format: String = "text"): Book() {
    private var currentWords = 0
    override val readPage:() -> Int = {currentWords+250}
}

fun main() {
    val book = Book("Harry Potter","JK Rowling")
    val ebook = eBook()
    println(book.readPage())
    println(ebook.readPage())
}

/*
Output:
2
250
*/
