data class Person(val name: String, val age: Int)

fun main() {
    val john = Person("John", 20)
    val newJohn = john.copy(age = 25)
    println(newJohn)
}