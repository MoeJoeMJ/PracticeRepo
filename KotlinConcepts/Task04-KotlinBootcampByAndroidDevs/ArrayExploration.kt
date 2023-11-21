fun main() {
    val arr: Array<Int>
    arr = arrayOf(1,2,3)
    arr[0] = 2
    println(arr.contentToString())  // [2, 2, 3]

    val newArr = Array(5) {it + 1}
    println(newArr.contentToString())  // [1, 2, 3, 4, 5]
    arr.forEach { print("${it*2} ") }  // 4 4 6
    println()
    for ((index,element) in arr.withIndex() ) {
        println("$element is in ${index}th position")  // Outputs:   2 is in 0th position
                                                       //            2 is in 1th position
                                                       //            3 is in 2th position
    }
}