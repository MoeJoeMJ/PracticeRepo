fun main() {
    val list1: List<Int> = listOf(1, 2, 3)
    val list2: List<Int> = listOf(1, 2, 3)
    val list3 = list1

    println("is list1 and list2 structurally same? : ${list1 == list2}")
    println("is list1 and list2 referentially same? : ${list1 === list2}")
    println("is list1 and list3 structurally same? : ${list1 == list3}")
    println("is list1 and list3 referentially same? : ${list1 === list3}")
    println("---------------------------------------------------")
    


    val num1 = 1
    val num2 = 1
    val num3 = num1

    println("is num1 and num2 structurally same? : ${num1 == num2}")
    println("is num1 and num2 referentially same? : ${num1 === num2}")  // For primitive values === check is equivalent to ==
    println("is num1 and num3 structurally same? : ${num1 == num3}")
    println("is num1 and num3 referentially same? : ${num1 === num3}")
}