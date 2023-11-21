package KotlinEssentials

const val MAX_NUMBER_BOOKS = 20

class NewBook(val title: String) {
    fun canBorrow(hasBooks: Int): Boolean {
        return (hasBooks < MAX_NUMBER_BOOKS)
    }

    object Constants {
        const val BASE_URL = "http://learingkotlin.net/"
    }

    fun printUrl() {
        println(Constants.BASE_URL + title + ".html")
    }

    companion object {
        val BASE_URL = "http://www.learningkotlin.net/"
    }
}

fun main() {
    val newBook = NewBook("EffectiveJava")
    println(newBook.canBorrow(20))
    newBook.printUrl()
}

/*
Output:
false
http://learingkotlin.net/EffectiveJava.html
*/
