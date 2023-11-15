enum class Departments(val id: Int) {
    CSE(104), ECE(108), IT(110)
}

fun main() {
    println(Departments.CSE.name)
    println(Departments.CSE.ordinal)
    println(Departments.CSE.id)
}