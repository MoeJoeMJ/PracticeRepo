data class SafeEmployee (val name: String, var salary: Int)

fun employeeById(id: Int) = when(id) {
    1 -> SafeEmployee("Mary", 20)
    2 -> null
    3 -> SafeEmployee("John", 21)
    4 -> SafeEmployee("Ann", 23)
    else -> null
}

fun salaryById(id: Int) = employeeById(id)?.salary?:0 // Write your code here

fun main() {
    println((1..5).sumOf { id -> salaryById(id) })
}