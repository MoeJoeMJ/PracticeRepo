fun higherOrderFunction(num: Int, function: Int.() -> String): String {
    return num.function()
}

var addNum: (Int) -> String = { num -> num.plus(1).toString() }

fun minusNum(num: Int): String = num.minus(1).toString()
fun main() {
    println(higherOrderFunction(5, addNum))
    println(higherOrderFunction(5, ::minusNum))  // passes reference instead of calling the function

}